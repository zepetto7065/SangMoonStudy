package me.zepetto.demobootweb;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

//    @GetMapping("/hello/{name}")
//    public String hello(@PathVariable("name") Person person){ //ApplicationContext의 Fomatter를 이용하여 Person 객체로 받아보자.
//        return "hello "+ person.getName();
//    }
    @GetMapping("/hello")
    public String hello(@RequestParam("name") Person person){ //parameter 형식으로도 받을 수 있다.
        return "hello "+ person.getName();
    }

}
