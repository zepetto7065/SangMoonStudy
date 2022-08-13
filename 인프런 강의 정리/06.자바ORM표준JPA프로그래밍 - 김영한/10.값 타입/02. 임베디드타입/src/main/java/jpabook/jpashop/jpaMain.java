package jpabook.jpashop;

import javax.persistence.*;

import jpabook.jpashop.domain.*;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.List;

public class jpaMain
{
    public static void main(String[] args) {

        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        final EntityManager em = emf.createEntityManager();
        final EntityTransaction tx = em.getTransaction();

        tx.begin();

        try{
            Member member = new Member();
            member.setUsername("hello");
            member.setAddress(new Address("city","street","10"));
            member.setPeriod(new Period());

            em.persist(member);

            tx.commit();
        }catch(Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }

}
