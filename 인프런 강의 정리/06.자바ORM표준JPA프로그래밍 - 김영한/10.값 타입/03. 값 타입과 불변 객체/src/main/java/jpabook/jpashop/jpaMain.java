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
            Address address = new Address("city", "street", "100000");

            Member member = new Member();
            member.setUsername("member1");
            member.setHomeAddress(address);
            em.persist(member);


            //4.애초에 다른 객체를 만들어서 만들어주는 것이 깔끔할 수도 
            Address newAddress = new Address(address.getCity(), address.getStreet(), address.getZipcode());
            member.setHomeAddress(newAddress);



//            Address coptyAddress = new Address(address.getCity(), address.getStreet(), address.getZipcode()); //2. 값을 복사해서 사용하자
////            Address coptyAddress = address //객체의 공유 참조는 피할 수 없다.
//
//            Member member2 = new Member();
//            member2.setUsername("member2");
//            member2.setHomeAddress(coptyAddress);
//            em.persist(member2);

//            member.getHomeAddress().setCity("newCity"); //첫번쨰 주소만 newCity로 바꾸고 싶어 3. setter를 없애거나 private으로 setter 설정하여 Imuttable Object로 설계해아함

            tx.commit();
        }catch(Exception e){
            tx.rollback();
            e.printStackTrace();
        }finally {
            em.close();
        }
        emf.close();
    }

}
