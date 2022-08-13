package me.sinew.demo.controller;

import me.sinew.demo.RService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RController {

    @Autowired
    RService rService;

    @GetMapping("/")
    public String index(){
        return "성공";
    }

    @PostMapping("/post")
    public String post(){


        return rService.create();
    }
}
