package jpabook.jpashop.domain;

import javax.persistence.*;

import jpabook.jpashop.domain.*;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public class jpaMain
{
    public static void main(String[] args) {

        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        final EntityManager em = emf.createEntityManager();
        final EntityTransaction tx = em.   getTransaction();

        tx.begin();

        try{
            Member member = new Member();
            member.setUsername("member1");
            member.setHomeAddress(new Address("homeCity", "street", "10000"));

            //값타입 컬렉션에 저장
            member.getFavoriteFoods().add("치킨");
            member.getFavoriteFoods().add("족발");
            member.getFavoriteFoods().add("피자");

            member.getAddressHistory().add(new AddressEntity("old1", "street", "10000"));
            member.getAddressHistory().add(new AddressEntity("old2", "street", "10000"));

            em.persist(member); //값 타입 컬렉션에 다른 테이블임에 불구하고 라이프사이클이 같이 돌아간다 ( 저장된다 ) , 영속성 전이 + 고아객체 제거기능을 필수로 가진다.

            em.flush();
            em.clear();

            System.out.println("========= START ===========");
            Member findMember = em.find(Member.class, member.getId()); //컬렉션은 안져온다. 즉 컬렉션은 지연로딩 , embedded는 같이 불러온다. 
// 값타입 사용
//            //이때 가져온다.
//            List<Address> addressHistory = findMember.getAddressHistory();
//            for (Address address : addressHistory) {
//                System.out.println("address.getCity() = " + address.getCity());
//            }
//            Set<String> favoritFoods = findMember.getFavoriteFoods();
//            for (String favoritFood : favoritFoods) {
//                System.out.println("favoritFood = " + favoritFood);
//            }
//
//값타입 수정
            //homeCity -> newCity
            //값타입은 imutable 해야하는데.. 잘못하면 사이드 이펙트
//            findMember.getHomeAddress().setCity("newCity")
            Address a = findMember.getHomeAddress();
            findMember.setHomeAddress(new Address("newCity", a.getStreet(), a.getZipcode())); //새로넣어라

            //치킨 -> 한식 , 통째로 갈아끼어야한다.
            findMember.getFavoriteFoods().remove("치킨");
            findMember.getFavoriteFoods().add("한식");

            //주소 old1 -> newOld1
            //전부다지우고 old2, newCity1 삽입
            //값 타입 컬렉션에 변경사항 발생시, 주인 엔티티와 연관된 모든 데이터 삭제후, 값타입 컬렉션에 있는 현재값을 모두 저장
            //따라서.. 값타입 컬렉션 매핑 테이블의 모든 컬럼은 기본키로 구성해야함 ( null x , 중복 저장 x)
//            findMember.getAddressHistory().remove(new Address("old1", "street","10000"));
//            findMember.getAddressHistory().add(new Address("newCity1", "street", "10000"));

            //실무에서는 상황에따라 값타입 대신 일대다 관계 고려
            //값타입컬렉션은 언제쓸까.. 치킨, 피자 먹고싶은거 여러개 체크체크.. 단순한거 ..
            //정말 값타입이라 판단될떄 사용

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
