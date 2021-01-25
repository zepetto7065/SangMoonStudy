package me.zepetto.demospring51;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test") // Bean들의 그룹 설정 //test라는 프로파일 일때만 사용가능
public class TestConfiguration {

    @Bean
    public BookRepository bookRepository(){
        return new TestBookRepository();
    }


}ㅇ

