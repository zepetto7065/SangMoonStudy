package me.zepetto.springapplicationcontext;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;

@Configuration
@ComponentScan(basePackageClasses = SpringapplicationcontextApplication.class)
public class ApplicationConfig {

//    @Bean
//    public BookRepository bookRepository(){
//        return new BookRepository();
//    }
//
//    @Bean
//    public BookService bookService(){
//        BookService bookService = new BookService(); //또는 파라미터로 받아서 사용가능하다.
//        bookService.setBookRepository(bookRepository());
//        return bookService();
//    }

}
