package jpabook.jpashop;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import jpabook.jpashop.domain.Item;
import jpabook.jpashop.domain.Movie;

public class jpaMain
{
    public static void main(String[] args) {

        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        final EntityManager em = emf.createEntityManager();
        final EntityTransaction tx = em.getTransaction();

        tx.begin();

        try{
            Movie movie = new Movie();
            movie.setDirector("aaaa");
            movie.setActor("bbbb");
            movie.setName("바락ㅁ과 함께 사라지다");
            movie.setPrice(10000);

            em.persist(movie);

            em.flush(); //영속성 컨텍스트 날리고
            em.clear(); //비운다
            Movie findMovie = em.find(Movie.class, movie.getId());
            Item item = em.find(Item.class, movie.getId());
            System.out.println("findMovie = " + findMovie); //조인을 해서 가져온다.



            tx.commit();
        }catch(Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}
