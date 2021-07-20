import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class jpaMain {
    public static void main(String[] args) {
        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        final EntityManager em = emf.createEntityManager();
        final EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
            //1. remove -> delete 쿼리가 쓰기지연 영역에 저장 된다. , 영속성 컨텍스트와 DB에서 모두 삭제 -> 캐시 + DB 둘다 삭제
            //2. detached -> 영속 관리를 하지않는다. 단 1차캐시에 데이터가 남아있다.
            // , 영속성 컨텍스트가 관리하던 영속상태의 엔티티를 영속성 컨텍스트가 관리하지 않는 상태
            Member member = em.find(Member.class, 102L);
            em.detach(member);

            member.setId(103L);
            System.out.println("member.getId() = " + member.getId());

            em.persist(member);

            tx.commit();
        }catch (Exception e){
            System.out.println("e ---> "+e.getMessage());
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}
