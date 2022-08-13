package jpabook.jpashop.domain;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import jpabook.jpashop.domain.*;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public class jpaMain {
    public static void main(String[] args) {

        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        final EntityManager em = emf.createEntityManager();
        final EntityTransaction tx = em.getTransaction();

        tx.begin();

        try {

            //jpql
            //m 이라하는건 Member 자체를 조회하므로 엔티티 지향하는 쿼리라 볼 수 있다.
//            List<Member> resultList = em.createQuery("select m from Member m where m.username like '%kim%' ",
//                    Member.class)
//                    .getResultList();
//
//            for (Member member : resultList) {
//                System.out.println("member.getUsername() = " + member.getUsername());
//            }

            //criteria
//            CriteriaBuilder cb = em.getCriteriaBuilder();
//            CriteriaQuery<Member> query = cb.createQuery(Member.class);
//            //루트생성
//            Root<Member> m = query.from(Member.class);
//            //쿼리생성
//            CriteriaQuery<Member> cq = query.select(m).where(cb.equal(m.get("username"), "kim"));
//            List<Member> resultList = em.createQuery(cq).getResultList();

            //native query
            //진짜 쿼리를 날려보자
            List resultList = em.createNativeQuery("select Member_ID, city, street, zipcode FROM Member").getResultList();


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
