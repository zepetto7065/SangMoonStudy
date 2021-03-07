package jpql;

import javax.persistence.*;
import java.util.List;

public class jpaMain {
    public static void main(String[] args) {

        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        final EntityManager em = emf.createEntityManager();
        final EntityTransaction tx = em.getTransaction();

        tx.begin();

        try {
            Member member = new Member();
            member.setUsername("member1");
            member.setAge(10);
            em.persist(member);

            em.flush();
            em.clear();
//            List<Team> result = em.createQuery("select m.team from Member m", Team.class) //m.team시 조인쿼리, 예측하기 힘들다. 참고로 묵시적 조인
//                    .getResultList();

//            Member findMember = result.get(0);
//            findMember.setAge(20);

//            List<Address> result = em.createQuery("select o.address from Order o", Address.class) //임베디드 타입 프로젝션, 어느 소속인지 정하고 써야한다. ( 값타입의 한계 )
//                    .getResultList();

//            List resultList = em.createQuery("select distinct m.username, m.age from Member m") //막가져오는 스탈라 타
//                    .getResultList();
//
//            //타입이 없으니 Object or 제네릭에 Object[]을 선언하자 .
//            Object o = resultList.get(0);
//            Object[] result = (Object[]) o;
//            System.out.println("result[0] = " + result[0]);
//            System.out.println("result[0] = " + result[1]);

            //패키지 명이 길어지면 길어지는 한계가 있다.
            List<MemberDTO> resultList = em.createQuery("select new jpql.MemberDTO( m.username, m.age ) from Member m", MemberDTO.class)
                    .getResultList();

            MemberDTO memberDTO = resultList.get(0);
            System.out.println("memberDTO = " + memberDTO.getUsername());

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
        emf.close();
    }

}
