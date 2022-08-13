package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
//jpa 모든 데이터 변경이나 로직들은 가급저거 트랜잭션안에서 작동
//java, spring 두개가 있는데 가급적 스프링 고나련 어노테이션을 사용하자.
@Transactional(readOnly = true) //읽기는 readOnly=true 로 최적화
//@AllArgsContructor 3번전략
@RequiredArgsConstructor //4번전략 final 을 가지고 있는 생성자를 만들어준다. 아래 코드 전부생략가능
public class MemberService {

    private final MemberRepository memberRepository;
    //final로 해놓으면 컴파일시점에서 오류 확인 가능 ( 생성자에 초기화 안했을때)

    //2번전략
    //@Autowired // 생성자 Injection 중간에 set을 할수 없다. test case 작성시
    //member service에 의존함을 명확하게 알수 있다.
    //코드가 번거롭다. 최신버전 스프링에서는 @Autowired 없어도 인젝션이 가능하다.
//    public MemberService(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }

    //1번전략
   //  runtime 외에 누군가가 바꿀수 있다.
    // 그런데 보통 없다.
//    @Autowired
//    public void setMemberService(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }

    //회원 가입
    @Transactional //따로 설정 readOnly false (default 값)
    public Long join(Member member){
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId(); //domain @id 가 key 값이 된다. 이렇게 값을 꺼내도 보장이된다.
    }

    //중복회원검증 로직
    private void validateDuplicateMember(Member member) {
        //EXEPTION
        final List<Member> findMembers = memberRepository.findByName(member.getName());
        if(!findMembers.isEmpty()){
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    //회원 전체 조회
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Member findOne(Long memberId){
        return memberRepository.findOne(memberId);
    }


}
