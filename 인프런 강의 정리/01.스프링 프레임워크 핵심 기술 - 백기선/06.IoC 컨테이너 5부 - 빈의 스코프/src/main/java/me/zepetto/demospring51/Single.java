package me.zepetto.demospring51;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Single {

    // 매번 다른 인스턴스가 들어오므로 문제가 된다.
    @Autowired
    Proto proto;

    public Proto getProto() {
        return proto;
    }
}
