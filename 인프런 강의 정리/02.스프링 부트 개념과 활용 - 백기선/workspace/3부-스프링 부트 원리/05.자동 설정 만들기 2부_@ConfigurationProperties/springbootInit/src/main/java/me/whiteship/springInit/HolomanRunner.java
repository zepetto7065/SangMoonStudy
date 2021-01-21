package me.whiteship.springInit;

import me.whiteship.Holoman;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class HolomanRunner implements ApplicationRunner {

    @Autowired
    Holoman holoman; //이 프로젝트 어디서도 Bean으로 등록하지 않았다.

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(holoman);
    }

}

