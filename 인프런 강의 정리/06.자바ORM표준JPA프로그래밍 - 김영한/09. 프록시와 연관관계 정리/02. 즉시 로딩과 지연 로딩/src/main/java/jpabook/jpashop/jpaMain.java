package jpabook.jpashop;

import javax.persistence.*;

import jpabook.jpashop.domain.Item;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.Movie;
import jpabook.jpashop.domain.Team;

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
    //Member를 조회할때 Team도 DB에서 조회를 해야할까?
        try{

            Team team = new Team();
            team.setName("teamA");
            em.persist(team);


            Member member = new Member();
            member.setUsername("hello");
            member.setTeam(team);

            em.persist(member);

            em.flush();
            em.clear();

            Member m = em.find(Member.class, member.getId());
            System.out.println("m.getTeam().getClass() = " + m.getTeam().getClass());

            System.out.println("================");
            System.out.println("teamName == "+ m.getTeam().getName());
            m.getTeam().getName(); //team의 실제 메서드를 사용하는 순간 쿼리가 나간다.
            System.out.println("================");

            //JPA가 jpql을 번역하는 과정에서 Member의 team이 즉시로딩이 되어있네
            // 그러면 Member쿼리 나가고 또 별도의 쿼리가 나간다.-> select * from Member, select * from Team where Team id = ---
//            // SQL d
//            List<Member> members = em.createQuery("select m from Member m", Member.class)
//                    .getResultList();


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
