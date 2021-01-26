package me.zepetto.demoapplicationeventpublisher;

import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class MyEventHandler{
    //빈으로는 등록되어야 스프링이 인식한다.
    @EventListener
//    @Order(Ordered.HIGHEST_PRECEDENCE + 2) 
    @Async //비동기로도 가능
    public void handle(MyEvent event) {
        System.out.println(Thread.currentThread().toString());
        System.out.println("이벤트 받았다. 데이터는 "+event.getData());
    }

    @EventListener
    @Async
    public void handle(ContextRefreshedEvent event) {
        System.out.println(Thread.currentThread().toString());
        System.out.println("COntextRefreshEvent");
    }


    @EventListener
    @Async
    public void handle(ContextClosedEvent event) {
        System.out.println(Thread.currentThread().toString());
        System.out.println("COntextRefreshEvent");
    }


}
