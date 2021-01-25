package me.zepetto.demoenviroment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements ApplicationRunner {

    @Autowired
    ApplicationContext ctx;

    @Value("${app.name}")
    String appName;

    @Override
    public void run(ApplicationArguments args) {
        final Environment environment = ctx.getEnvironment();
        System.out.println(environment.getProperty("app.name"));
        System.out.println(environment.getProperty("app.name"));
        System.out.println(appName);
    }
}
