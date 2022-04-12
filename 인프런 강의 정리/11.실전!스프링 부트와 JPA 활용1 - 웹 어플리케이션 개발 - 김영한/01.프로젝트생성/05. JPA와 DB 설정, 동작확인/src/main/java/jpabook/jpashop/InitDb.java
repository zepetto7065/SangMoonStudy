package jpabook.jpashop;

import jpabook.jpashop.domain.*;
import jpabook.jpashop.domain.item.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

//최초 구동시 데이터 삽입
@Component
@RequiredArgsConstructor
public class InitDb {

    private final InitService initService;

    @PostConstruct
    public void init(){
        initService.dbinit1();
        initService.dbinit2();
        initService.dbinit3();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService{
        //별도의 빈으로 등록하는 이유는 transaction 먹이는 등 ,
        //postConstruct 안에서 잘안된다.
        private final EntityManager em;
        private final ItemRepository2 itemRepository2;


        public void dbinit1() {
            Member member = createMember("userA", "서울", "1", "11");
            em.persist(member);

            Book book1 = createBook("JPA1 Book", 10000, 100);
            em.persist(book1);

            Book book2 = createBook("JPA2 Book", 20000, 100);
            em.persist(book2);

            OrderItem orderItem1 = OrderItem.createOrderItem(book1, 10000, 1);
            OrderItem orderItem2 = OrderItem.createOrderItem(book2, 20000, 2);

            Order order = createDelivery(member, orderItem1, orderItem2);
            em.persist(order);
        }

        public void dbinit2(){
            Member member = createMember("userB", "진주", "2", "22");
            em.persist(member);

            Book book1 = createBook("SPRING1 Book", 20000, 200);
            em.persist(book1);

            Book book2 = createBook("SPRING2 Book", 40000,300);
            em.persist(book2);

            OrderItem orderItem1 = OrderItem.createOrderItem(book1, 20000, 3);
            OrderItem orderItem2 = OrderItem.createOrderItem(book2, 40000, 4);

            Order order = createDelivery(member, orderItem1, orderItem2);
            em.persist(order);
        }

        private Order createDelivery(Member member, OrderItem orderItem1, OrderItem orderItem2) {
            Delivery delivery = new Delivery();
            delivery.setAddress(member.getAddress());
            Order order = Order.createOrder(member, delivery, orderItem1, orderItem2);
            return order;
        }

        private Member createMember(String name, String city, String street, String zipcode) {
            Member member = new Member();
            member.setName(name);
            member.setAddress(new Address(city, street, zipcode));
            return member;
        }

        private Book createBook(String book, int price, int stockQuantity) {
            Book book1 = new Book();
            book1.setName(book);
            book1.setPrice(price);
            book1.setStockQuantity(stockQuantity);
            return book1;
        }

        public void dbinit3(){
            Book book = new Book();
            book.setAuthor("test");
            book.setIsbn("isbn");
            book.setStockQuantity(100);
            book.setName("test");

            itemRepository2.save(book);
        }
    }
}
