package me.kakao.logintest.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

    @GetMapping("/")
    public String index(){
        return "home";
    }

    @GetMapping("/hello")
    public String helloView(){
        return "hello";
    }

    @GetMapping("/login")
    public String loginView(){
        return "login";
    }
}
