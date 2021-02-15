package hellojpa;

import javax.persistence.*;

public class jpaMain {
    public static void main(String[] args) {

        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        final EntityManager em = emf.createEntityManager();
        final EntityTransaction tx = em.getTransaction();

        tx.begin();

        try{
            Member member1 = new Member();
            member1.setUsername("A");
            Member member2 = new Member();
            member2.setUsername("B");
            Member member3 = new Member();
            member3.setUsername("C");

            System.out.println("=============================");

            em.persist(member1); //1, 51
            em.persist(member2); //MEM
            em.persist(member3); //MEM

            System.out.println("member.id = "+ member1.getId());
            System.out.println("member.id = "+ member2.getId());
            System.out.println("member.id = "+ member3.getId());
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
