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
            Child child1 = new Child();
            Child child2 = new Child();

            Parent parent = new Parent();
            parent.addChild(child1);
            parent.addChild(child2);
            //parent persit할떄 같이 되면 안되나?
            em.persist(parent);
//            em.persist(child1);
//            em.persist(child2);

            //orphan
            em.flush();
            em.clear();
            Parent findParent = em.find(Parent.class, parent.getId());
            em.remove(findParent);

            tx.commit();
        }catch(Exception e){
            e.printStackTrace();
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }

    private static void printMember(Member member) {
        //여기서 Team까지 가져오는건 사실상 최적회가 아니다. -> 어느경우에는 Member만 사용할때가 있다.
        //JPA는 지연 로딩 과 프록시로 해결
        System.out.println("member.getUsername() = " + member.getUsername());
    }

    private static void printMemberAndTeam(Member member) {
        String name = member.getUsername();
        System.out.println("name = " + name);

        Team team = member.getTeam();
        System.out.println("team = " + team.getName());
    }

}
