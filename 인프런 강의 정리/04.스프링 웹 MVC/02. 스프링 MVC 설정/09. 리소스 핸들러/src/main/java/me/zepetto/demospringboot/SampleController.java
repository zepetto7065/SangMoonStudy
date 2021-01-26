package me.zepetto.demospringboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {
    
    // preHandle 1
    // preHandle 2
    // 요청처리
    // postHandle 2
    // postHandle 1
    // 뷰 랜더링
    // afterCompletion 2
    // afterCompletion 1

    @GetMapping("/hello")
    public String hello(@RequestParam("id") Person person){
        return "hello " + person.getName();
    }

}
