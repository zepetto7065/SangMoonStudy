package me.zepetto;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class SpringInitApplication {

    public static void main(String[] args){
//        SpringApplication.run(SpringInitApplication.class,args);

//        SpringApplication app = new SpringApplication(SpringInitApplication.class);

//        app.setBannerMode(Banner.Mode.OFF); // 배너 모드를 끈다.
//        app.run(args);
        new SpringApplicationBuilder()
                .sources(SpringInitApplication.class)
                .run(args);
    }

}
