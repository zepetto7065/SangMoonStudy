package me.zepetto.demowebmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SampleController {

    @GetHelloMapping
    @ResponseBody
    public String hello(){
        return "hello";
    }


    //handler mapping 영역
    @PostMapping("/hello")
    @ResponseBody
    //
    //handler adapter 영역
    public String helloPost(){
        return "hello";
    }
    //
}
