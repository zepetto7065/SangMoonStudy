package me.zepetto.demoenviroment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:/app.properties")
public class DemoenviromentApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoenviromentApplication.class, args);
    }

}
