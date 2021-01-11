package me.whiteship.springInit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringInitApplication {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(SpringInitApplication.class);
		application.setWebApplicationType(WebApplicationType.NONE); //좀더 빠르게 뜨도록
		application.run(args);
	}

}
