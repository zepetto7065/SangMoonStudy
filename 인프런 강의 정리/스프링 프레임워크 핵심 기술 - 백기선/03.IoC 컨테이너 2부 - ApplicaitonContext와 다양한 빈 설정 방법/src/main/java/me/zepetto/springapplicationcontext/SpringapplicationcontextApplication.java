package me.zepetto.springapplicationcontext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class SpringapplicationcontextApplication {

    public static void main(String[] args) {
        //application.xml에 bean등록하여 사용할때
//        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
//        final String[] beanDefinitionNames = context.getBeanDefinitionNames();
//        System.out.println(beanDefinitionNames);
//        BookService bookService = (BookService) context.getBean("bookService");
//        System.out.println(bookService.bookRepository != null);

        //자바 config로 만든 빈 사용하기
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ApplicationConfig.class);
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        System.out.println(beanDefinitionNames);
        BookService bookService = (BookService) context.getBean("bookService");
        System.out.println(bookService.bookRepository != null);

    }

}
