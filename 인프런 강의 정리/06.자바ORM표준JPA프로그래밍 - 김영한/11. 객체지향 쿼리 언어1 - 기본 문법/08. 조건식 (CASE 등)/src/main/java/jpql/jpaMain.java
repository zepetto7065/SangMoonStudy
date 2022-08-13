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
            Team team = new Team();
            team.setName("teamA");
            em.persist(team);

            Member member = new Member();
            member.setUsername("member1");
            member.setAge(10);
            member.setType(MemberType.ADMIN);
            member.setTeam(team);

            em.persist(member);

            em.flush();
            em.clear();

//            String query = "select " +
//                    "case when m.age <= 10 then '학생요금' " +
//                    "when m.age >= 60 then '경로요금' "+
//                    "else '일반요금' end "+
//                    "from Member m";
//            String query = "select coalesce(m.username, '이름 없는 회원') from Member m ";
            String query = "select nullif(m.username, '관리자') from Member m ";

            List<String> resultList = em.createQuery(query, String.class).getResultList();

            for (String s : resultList) {
                System.out.println("s = " + s);
            }


        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
        emf.close();
    }

}
