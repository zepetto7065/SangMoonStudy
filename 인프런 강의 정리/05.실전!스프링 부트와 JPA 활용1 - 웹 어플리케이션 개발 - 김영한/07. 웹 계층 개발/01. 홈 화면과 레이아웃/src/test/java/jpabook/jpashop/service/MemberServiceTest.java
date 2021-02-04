package jpabook.jpashop.service;


import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.fail;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class) //spring과 엮어서 실행할래
@SpringBootTest //스프링 컨테이너를 사용하겠다.
@Transactional //작업이 끝나고 롤백한다.
public class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Autowired
    MemberRepository memberRepository;


    @Autowired
    EntityManager em;

    @Test
    @Rollback(value = false) //롤백안하겠다. insert 쿼리가 보여지게 된다.
    public void 회원가입() throws Exception{
        //given
        Member member = new Member();
        member.setName("kim");
        //when
        final Long saverId = memberService.join(member);
        //then
//        em.flush();    //롤백이지만 DB 쿼리 보고 싶을때
        assertEquals(member, memberRepository.findOne(saverId));
    }

    @Test(expected = IllegalStateException.class) //예외 터져 나온 Exception이 해당 Exception이면 통과
    public void 중복_회원_예외() throws Exception{
        //given
        Member member1 = new Member();
        member1.setName("kim1");

        Member member2 = new Member();
        member2.setName("kim1");

        //when
        memberService.join(member1);
//        try{
//            memberService.join(member2);//"예외가 발생해야 한다.
//        }catch (IllegalStateException e){
//            return;
//        }
        memberService.join(member2);
        //then
        fail("예외가 발생해야 한다.");
    }
}