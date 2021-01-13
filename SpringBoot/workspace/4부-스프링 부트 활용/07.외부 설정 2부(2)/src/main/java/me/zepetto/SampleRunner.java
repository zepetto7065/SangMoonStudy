package me.zepetto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class SampleRunner implements ApplicationRunner {

    @Autowired
    SangmoonProperties sangmoonProperties;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("==================");
        System.out.println(sangmoonProperties.getName());
        System.out.println(sangmoonProperties.getAge());
        System.out.println(sangmoonProperties.getSessionTimeout());
        System.out.println("==================");
    }
}
