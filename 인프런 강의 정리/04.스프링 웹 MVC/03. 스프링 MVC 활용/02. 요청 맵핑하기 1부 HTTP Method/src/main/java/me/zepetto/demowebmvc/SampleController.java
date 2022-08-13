package me.zepetto.demowebmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//@RequestMapping(method = RequestMethod.GET) // 해당 클래스 모두 Get으로
public class SampleController {

//    @RequestMapping(value = "/hello", method ={RequestMethod.GET, RequestMethod.PUT} ) //method를 지정하지 않으면 기본적으로 모든
    // httpmethod 전부 허용, 두개도 허용 가능
    @GetMapping("/hello")
    @ResponseBody
    public String hello(){
        return "hello";
    }

}
