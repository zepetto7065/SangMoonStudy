package me.zepetto.demospringboot21autoconfig;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Async
    //2.0대와 다른건 모든 ahync가 모든 같은 스레드에서 돌게 된다.
    public void hello(){
        System.out.println("hello " + Thread.currentThread().getName());
    }
}
