package jpabook.jpashop;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import jpabook.jpashop.domain.Item;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.Movie;
import jpabook.jpashop.domain.Team;

import java.awt.*;
import java.time.LocalDateTime;

public class jpaMain
{
    public static void main(String[] args) {

        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        final EntityManager em = emf.createEntityManager();
        final EntityTransaction tx = em.getTransaction();

        tx.begin();
    //Member를 조회할때 Team도 DB에서 조회를 해야할까?
        try{
            Member member = new Member();
            member.setUsername("hello");

            em.persist(member);
            
            em.flush();
            em.clear();
            
            //영속성 컨텍스트 초기화
//            Member findMember = em.find(Member.class, member.getId());
            Member findMember = em.getReference(Member.class, member.getId()); //가짜 레퍼런스
            System.out.println("findMember.getClass() = " + findMember.getClass()); //hibernate가 강제로 만든 프록시 클래스
            System.out.println("findMember.getId() = " + findMember.getId()); //getReference에서 사용
            System.out.println("findMember.getUsername() = " + findMember.getUsername());// 어? 없네 하고 DB에 쿼리를 날린다. 실제 사용될때 쿼리가 호출




//            Member member = em.find(Member.class, 1L);
//            printMemberAndTeam(member);
//            printMember(member);
            
            tx.commit();
        }catch(Exception e){
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
