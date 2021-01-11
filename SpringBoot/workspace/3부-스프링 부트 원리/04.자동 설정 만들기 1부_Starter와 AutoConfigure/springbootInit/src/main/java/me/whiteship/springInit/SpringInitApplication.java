package me.whiteship.springInit;

import me.whiteship.Holoman;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringInitApplication {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(SpringInitApplication.class);
		application.setWebApplicationType(WebApplicationType.NONE); //좀더 빠르게 뜨도록
		application.run(args);
	}

	//명시적으로 Bean 을 따로 등록할 때
	@Bean 
	public Holoman holoman(){
		Holoman holoman = new Holoman();
		holoman.setName("WhiteShip");
		holoman.setHowLong(60);
		return holoman;
	}

}
