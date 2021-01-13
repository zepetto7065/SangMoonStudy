package me.zepetto;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class SampleListner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(args);
    }

//    public SampleListner(ApplicationArguments arguments){
//        System.out.println("foo: "+arguments.containsOption("foo"));
//        System.out.println("bar: "+arguments.containsOption("bar"));
//    }

}
