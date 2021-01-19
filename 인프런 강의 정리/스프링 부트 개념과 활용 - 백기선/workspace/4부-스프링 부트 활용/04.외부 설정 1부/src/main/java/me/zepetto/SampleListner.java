package me.zepetto;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class SampleListner implements ApplicationRunner {

    @Value("${sangmoon.fullName}")
    private String name;

    @Value("${sangmoon.age}")
    private int age;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("===================");
        System.out.println(name);
        System.out.println(age);
        System.out.println("===================");
    }

}
