package hellojpa;

import javax.persistence.*;

public class jpaMain {
    public static void main(String[] args) {

        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        final EntityManager em = emf.createEntityManager();
        final EntityTransaction tx = em.getTransaction();

        tx.begin();

        try{
            Member member = em.find(Member.class, 150L);
            member.setName("AAAA");

            em.detach(member);
//            em.clear();
//            Member member2 = em.find(Member.class, 150L);

            System.out.println("=============================");
            tx.commit();
        }catch(Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}
