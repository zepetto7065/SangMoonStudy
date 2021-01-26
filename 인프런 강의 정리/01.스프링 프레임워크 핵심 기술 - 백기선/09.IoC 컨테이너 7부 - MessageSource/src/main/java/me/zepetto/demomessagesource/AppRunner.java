package me.zepetto.demomessagesource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class AppRunner implements ApplicationRunner {
    @Autowired
    ApplicationContext messageSource;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        while(true){
            System.out.println(messageSource.getClass());
            System.out.println(messageSource.getMessage("greeting",new String[]{"sangmoon"}, Locale.ENGLISH));
            System.out.println(messageSource.getMessage("greeting",new String[]{"sangmoon"}, Locale.getDefault()));
            Thread.sleep(1000);
        }

    }
}
