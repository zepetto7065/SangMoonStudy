package me.zepetto.demospring51;

import me.zepetto.out.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.function.Supplier;

@SpringBootApplication
public class Demospring51Application {

//    @Autowired
//    MyService myService; //코드에서 Bean등록을 안해도 import 되지만 Scan이 되지는 않는다.

    public static void main(String[] args) {
        //jdk11부터 사용 가능 문법 , 어노테이션이 아닌 펑션을 이용한 빈등록, 성능상의 이점이 있다.
        //하지만 componentScan을 버리고 이렇게 등록을 하는것에 대해 ...어마어마한 설정파일이 생길수도있다.
        //직접 빈등록을 할떄 (@Bean) 이러한 방법을 쓰는것도 나쁘지 않을 것 같다.
        var app = new SpringApplication(Demospring51Application.class);
        app.addInitializers((ApplicationContextInitializer<GenericApplicationContext>) ctx -> {
            ctx.registerBean(MyService.class);
            ctx.registerBean(ApplicationRunner.class, () -> args1 -> System.out.println("Functional Bean Definition"));
        });
        app.run(args);
    }

}
