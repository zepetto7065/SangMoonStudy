package me.zepetto.demowebmvc;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SampleController {


//    @RequestMapping(value="/hello", headers= HttpHeaders.FROM) //FROM이라는 해더가 있는 경우에만 처리
//    @RequestMapping(value="/hello", headers= "!"+ HttpHeaders.AUTHORIZATION) // AUTHORIZAION 이 아니어야할 때
    @RequestMapping(value="/hello", headers= HttpHeaders.AUTHORIZATION + "=" + "111") // AUTHORIZAION 이 아니어야할 때
    @ResponseBody
    public String hello(){
        return "hello";
    }

    // "/hello?name=keesun
    @GetMapping(value="/name", params = "name=keesun") //name이라는 parameter가 있어야한다.
    @ResponseBody
    public String name(){
        return "keesun";
    }

}
