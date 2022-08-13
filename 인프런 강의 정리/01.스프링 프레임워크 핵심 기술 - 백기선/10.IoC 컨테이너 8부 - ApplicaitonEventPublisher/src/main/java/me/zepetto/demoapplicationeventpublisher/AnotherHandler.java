package me.zepetto.demoapplicationeventpublisher;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class AnotherHandler {
    @EventListener
//    @Order(Ordered.HIGHEST_PRECEDENCE) //가장 높은 우선 순위를 준다.
    @Async
    public void handle(MyEvent myEvent){
        System.out.println(Thread.currentThread().toString());
        System.out.println("Another " + myEvent.getData());
    }
}
