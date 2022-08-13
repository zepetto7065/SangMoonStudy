package hellojpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class jpaMain
{
    public static void main(String[] args) {

        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        final EntityManager em = emf.createEntityManager();
        final EntityTransaction tx = em.getTransaction();


        tx.begin();

        try{
            //팀 저장
            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);

            //회원 저장
            Member member = new Member();
            member.setName("member1");
            member.changeTeam(team); //**
            em.persist(member);

            //역방향(주인이 아닌 방향)만 연관관계 설정 -> 읽기전용이기떄문에 값이 들어가지 않는다.
            //값을 넣어주지 않아도 값이 출력된다.
            //그런데.. 2군데에서 문제가 된다.
            //1. flush clear 해줄시 문제 없음. 하지만 안해주면 1차캐시에 존재하지 않는 상황.
            //2. test case
            // 결국엔 다 셋팅을 해주어야한다.
//            team.addMember(member); // team 기준으로 만들경우
            
            em.flush();
            em.clear();

            final Team findTeam = em.find(Team.class, team.getId());
            final List<Member> members = findTeam.getMembers();

            System.out.println("====================================");
            System.out.println("findTeam = " + findTeam);
            System.out.println("====================================");

            tx.commit();
        }catch(Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}
