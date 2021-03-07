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
            em.persist(member);

            TypedQuery<Member> query = em.createQuery("select m from Member m", Member.class);
            List<Member> resultList = query.getResultList();
            TypedQuery<String> query2 = em.createQuery("select m.username from Member m", String.class);
            Query query3 = em.createQuery("select m.username, m.age from Member m");

            //try catch를 쓰면 되지만...
            Member result = query.getSingleResult();
            System.out.println("result = " + result);

            //파라미터 바인딩
            TypedQuery<Member> query4 =
                    em.createQuery("select m from Member m " +
                                    "where m.username = :username",
                            Member.class)
                            .setParameter("username", "member1");




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
