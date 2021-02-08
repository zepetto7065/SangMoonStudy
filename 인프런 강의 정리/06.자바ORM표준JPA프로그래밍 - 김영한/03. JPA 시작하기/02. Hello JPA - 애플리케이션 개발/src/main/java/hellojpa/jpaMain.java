package hellojpa;

import javax.persistence.*;
import java.util.List;

public class jpaMain {
    public static void main(String[] args) {
        // persistence.xml에 설정한 unit name을 넘긴다
        // 웹서버당 1개
        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        //쓰레드간에 공유는 x ( 사용하고 버리자)
        final EntityManager em = emf.createEntityManager();
        final EntityTransaction tx = em.getTransaction();

        tx.begin();

        try{
//            Member member = new Member();
//            //jpa는 트랜잭션 안에서 작업을 해야한다.
//            member.setId(2L);
//            member.setName("HelloB");
//            final Member findMember = em.find(Member.class, 1L);
//            findMember.setName("HelloJPA")
//            System.out.println("findMember.id === "+findMember.getId());
//            System.out.println("findMember.name === "+findMember.getName());
//            em.persist(member);
            //JPQL은 엔티티 객체를 대상으로 쿼리
            final List<Member> result = em.createQuery("select m from Member as m", Member.class)
                    .setFirstResult(1)
                    .setMaxResults(10)
                    .getResultList();

            for(Member member:result){
                System.out.println("member.name = "+ member.getName());
            }

            tx.commit();
        }catch(Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}
