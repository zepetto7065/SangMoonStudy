package me.zepetto.overidingchange;

import me.zepetto.demofamillymanprep.FamilyMan;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OveridingchangeApplication {

    public static void main(String[] args) {
        SpringApplication.run(OveridingchangeApplication.class, args);
    }

    @Bean
    public ApplicationRunner applicationRunner(){
        return args -> {
            System.out.println("===================");
            System.out.println(familyMan().getName());
            System.out.println("===================");
        };
    }

    @Bean
    public FamilyMan familyMan(){
        FamilyMan familyMan = new FamilyMan();
        familyMan.setName("keesun");
        return familyMan;
    }

}
