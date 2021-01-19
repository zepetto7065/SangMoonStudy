package me.zepetto.springbootadminmonitor;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAdminServer
@SpringBootApplication
public class SpringbootadminmonitorApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootadminmonitorApplication.class, args);
    }

}
