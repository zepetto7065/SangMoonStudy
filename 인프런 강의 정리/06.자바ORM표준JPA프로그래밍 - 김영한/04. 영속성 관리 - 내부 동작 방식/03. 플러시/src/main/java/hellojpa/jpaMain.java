package hellojpa;

import javax.persistence.*;

public class jpaMain {
    public static void main(String[] args) {

        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        final EntityManager em = emf.createEntityManager();
        final EntityTransaction tx = em.getTransaction();

        tx.begin();

        try{
            Member member1 = new Member(200L , "member200");
            em.persist(member1);

            em.flush();
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
