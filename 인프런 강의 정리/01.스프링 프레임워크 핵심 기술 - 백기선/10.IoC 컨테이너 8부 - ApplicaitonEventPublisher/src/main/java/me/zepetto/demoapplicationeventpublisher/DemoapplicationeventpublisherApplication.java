package me.zepetto.demoapplicationeventpublisher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class DemoapplicationeventpublisherApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoapplicationeventpublisherApplication.class, args);
    }

}
