package hellojpa;

import javax.persistence.*;

public class jpaMain {
    public static void main(String[] args) {

        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        final EntityManager em = emf.createEntityManager();
        final EntityTransaction tx = em.getTransaction();

        tx.begin();Member member1 = new Member(150L , "A");
        Member member2 = new Member(160L , "B");
        em.persist(member1);
        em.persist(member2);

        System.out.println("========================");


        tx.commit();

        try{

        }catch(Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}
