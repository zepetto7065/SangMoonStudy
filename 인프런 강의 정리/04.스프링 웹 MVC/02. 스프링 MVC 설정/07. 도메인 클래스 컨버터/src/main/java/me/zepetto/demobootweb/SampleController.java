package me.zepetto.demobootweb;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    @GetMapping("/hello")
    public String hello(@RequestParam("id") Person person){ //id를 parameter로 받을 때는 SpringJPA기능을 지원받아 객체로 Formmater없이
        return "hello "+ person.getName();
    }

}
