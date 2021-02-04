package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

//    @PersistenceContext
    private EntityManager em;

    // 스프링부트가 @PersistenceContext -> 아래 코드와 같이 사용가능 하다 . 
    // MemberService와 마찬가지로 @RequiredArgsConstructor로 변경가능
//    @Autowired
//    private EntityManager em;
//
//    public MemberRepository(EntityManager em){
//        this.em = em;
//    }

//    @PersistenceUnit //managefactory를 직접 주입 받을 수 있다.


    public void save(Member member){
        em.persist(member);
    }

    public Member findOne(Long id){
        return em.find(Member.class, id);
    }

    //JPQL 사용
    public List<Member> findAll(){
        return em.createQuery("select m from Member m", Member.class) //두번쨰는 반환타입
                .getResultList();
    }

    public List<Member> findByName(String name){
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }



}
