package me.zepetto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringInitApplication {


    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(SpringInitApplication.class);
        app.setWebApplicationType(WebApplicationType.NONE);
        //WebApplication 타입을 설정 가능. 기본적으로 Servlet, WebPlux-Reactive ,둘다 들어있다면 첫번째 Servlet
        app.run(args);
    }

}
