package me.zepetto.demoreoruceloader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Path;

@Component
public class AppRunner implements ApplicationRunner {
    @Autowired
    ResourceLoader resourceLoader;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        final Resource resource = resourceLoader.getResource("classpath:text.txt");
        System.out.println(resource.exists()); //없다.
        System.out.println(resource.getDescription());
        System.out.println(Files.readString(Path.of(resource.getURI()))); //java 11 readString
    }
}