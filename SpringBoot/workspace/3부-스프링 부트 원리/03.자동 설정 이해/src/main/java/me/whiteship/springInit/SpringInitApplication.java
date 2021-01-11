package me.whiteship.springInit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringInitApplication {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(SpringInitApplication.class);
		application.run(args);
	}

}
