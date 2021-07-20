package me.zepetto.springtest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/content")
    public String content(){
        return "views/content";
    }

    @GetMapping("/hello")
    public String hello(){
        return "views/hello";
    }

}
