package me.zepetto.demospringboot;

import org.springframework.web.bind.annotation.*;

@RestController
public class SampleController {

    @GetMapping("/hello")
    public String hello(@RequestParam("id") Person person){
        return "hello " + person.getName();
    }

    @GetMapping("/message")
    //@ResponseBody //메세지를 HttpMessage컨버터를 통해 응답에 넣어주지만 Restcontroller을 사용하므로 굳이 적용하지 않아도 된다. 생략가능
    public String message(@RequestBody String message){ //요청 본문에 들어있는 메세지를 HttpMessage컨버터를 사용해서 컨버젼
        return message;
    }

}
