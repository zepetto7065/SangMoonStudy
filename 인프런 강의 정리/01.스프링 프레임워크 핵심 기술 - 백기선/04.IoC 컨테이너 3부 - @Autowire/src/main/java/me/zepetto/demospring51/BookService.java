package me.zepetto.demospring51;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class BookService {

//    @Autowired(required = false)
//    BookRepository bookRepository; 3.필드에 주는 방법 (optional로 설정을 해서 Bean으로 등록하는 경우가 있다)
    @Autowired @Qualifier("yourBookRepository") //Autowire하고 싶은 Bean의 이름 단, 스몰케이스로 넣어야한다. @primary 추천
    BookRepository bookRepository;

//    @Autowired
//    List<BookRepository> bookRepositoryList; //모든 Bean을 주입받는 방법

//    @Autowired
//    BookRepository myBookRepository; //Bean이 두개 있을떄 이름을 보고 찾아 Bean 주입받을 수 있겠지만, 별로 추천하지 않는 방법

//    @PostConstruct //BeanFactory가 이 타입의 빈을 찾고 Processor 에 적용, 라이프 사이클에 조금더 공부해 보아야함
//    public void setUp(){
//        System.out.println(bookRepository.getClass());
//    }

    
     //1. 생성자에 Autowire 하는 방법
//    @Autowired
//    public BookService(BookRepository bookRepository) {
//        this.bookRepository = bookRepository;
//    }

    // 2. setter에 Autowire 하는 방법
//    생성자 주입은 Bean을 못찾아서 실패했다라고 직관적으로 알수 있다.
//    Autowire만 붙이고 Bean생성을 안했다면 인스턴스는 만들수 있지만 (setter로인해) Autowired가 빈을 찾으려고 하기때문에 에러
//    만약에 Optional 없어도 된다고 할떄 @Autowired(required = false) 로 해주면 된다. BookRepository는 의존성 주입이 안된 상태
//    @Autowired(required = false)
//    public void setBookRepository(BookRepository bookRepository) {
//        this.bookRepository = bookRepository;
//    }
    
//    @Repository 가 여러개일 경우 스프링이 주입해줄수 없다 (KeesunBookRepository , MyBookRepository)
    // 1.@Primary ,2. 모든 Bean을 주입받거나 ,3. @Qualifire 빈 이름 주입


    public void pringBookRepository(){
        System.out.println(bookRepository.getClass());
    }
    
}
