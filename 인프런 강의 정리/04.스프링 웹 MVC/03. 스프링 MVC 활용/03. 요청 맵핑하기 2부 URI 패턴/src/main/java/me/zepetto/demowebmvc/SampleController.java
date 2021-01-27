package me.zepetto.demowebmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//@RequestMapping(method = RequestMethod.GET)
@RequestMapping("/hello") //request 조합가능
public class SampleController {

//    @RequestMapping({"/hello","/hi"}) //두개를 매핑할 수도 있다.
//    @RequestMapping("/hello/*")
//    @RequestMapping("/hello/**")
//    @RequestMapping("/{name:[a-z]+}") //정규식 사용 가능 , 경로에 있는 것은 @PathVariable로 받자
//    @RequestMapping({"/keesun","/keesun.*"}) //keesun.html도 가능하게 할수 있게 한다. (암묵적으로)
    @RequestMapping("/keesun") //요즘 추세는 확장자를 안보더라도 accept header에 정보를 알려줘서 서버가 알수 있도록
    @ResponseBody
    public String helloKeesun(){
        return "hello keesun";
    }

    @RequestMapping("/**")
    @ResponseBody
    public String hello(){
        return "hello";
    }

}
