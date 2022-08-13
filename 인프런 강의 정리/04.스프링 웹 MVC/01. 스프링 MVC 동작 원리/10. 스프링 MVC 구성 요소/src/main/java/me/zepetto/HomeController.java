package me.zepetto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @Autowired
    HelloService helloService;

    //mv가 NULL 인 경우
    @GetMapping("/hello")
    @ResponseBody
    public String hello(){
        return "Hello, " + helloService.getName();
    }

    //이러한 문자열은 문자열로 인식하고
    //mv가 더이상 널이 아니고 해당하는 모델 객체를 바인딩해서
    //뷰를 response에 실어서 랜더링 한다.
    @GetMapping("/sample")
    public String sample(){
        return "sample";
    }


}
