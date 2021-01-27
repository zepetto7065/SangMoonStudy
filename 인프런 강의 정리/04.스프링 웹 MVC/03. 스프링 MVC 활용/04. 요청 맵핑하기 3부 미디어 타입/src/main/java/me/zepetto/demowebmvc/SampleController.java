package me.zepetto.demowebmvc;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(consumes = MediaType.APPLICATION_XML_VALUE)//method의 requestMapping이 overiding 하므로 적용 안된다.
public class SampleController {

    //요청의 Body타입이 Json일때만 처리하겠다?
    //@RequestMapping(value = "/hello", consumes = "application/json") //문자열은 오타 가능성
    @RequestMapping(
            value="/hello",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, //content-type header를 서버쪽에 알려준다., 배열로도 설정가능
            produces = MediaType.TEXT_PLAIN_VALUE) //accept-type header를 클라이언트쪽에 알려준다. 설정을 안하면 아무거나 받겠다.
    @ResponseBody
    public String hello(){
        return "hello";
    }

}
