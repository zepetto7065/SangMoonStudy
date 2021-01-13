package me.zepetto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApplicationInit {

    public static void main(String[] args){
        SpringApplication app = new SpringApplication(ApplicationInit.class);
        app.setWebApplicationType(WebApplicationType.NONE);
        app.run(args);
    }


}
