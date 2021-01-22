package me.zepetto.demospring51;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

public class BookServiceRunner implements ApplicationRunner {

    @Autowired
    BookService bookService;

    @Override
    public void run(ApplicationArguments args) {
        bookService.pringBookRepository();
    }
}
