package me.zepetto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringInitApplication {

    // 이런 케이스도 있다.
    // 이미 스프링에서 프로퍼티를 만들어졌을 법한 것들은 다음과 같이 빈 생성이 가능하다.
    // 이런 경우는 흔치 않다. 대부분 @Component anotation 을 붙여서 사용한다.
    @ConfigurationProperties("server")
    @Bean
    public ServerProperties serverProperties() {
        return new ServerProperties();
    }

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(SpringInitApplication.class);
        app.setWebApplicationType(WebApplicationType.NONE);
        app.run(args);
    }

}
