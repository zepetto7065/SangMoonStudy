package me.zepetto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Autowired
    HelloService helloService;

    @GetMapping("/hello")
    public String hello(){
        return "Hello, " + helloService.getName();
    }
}
