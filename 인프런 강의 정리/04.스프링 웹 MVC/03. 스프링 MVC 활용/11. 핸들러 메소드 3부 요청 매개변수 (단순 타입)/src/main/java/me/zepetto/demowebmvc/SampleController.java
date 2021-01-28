package me.zepetto.demowebmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class SampleController {

    @PostMapping("/events")
    @ResponseBody
    public Event getEvents(@RequestParam String name, @RequestParam Integer limit){
//    public Event getEvents(@RequestParam String name){
//    public Event getEvents(@RequestParam Map<String,String> param){ 이경우도 가능
        //@RequestParam 생략가능하나, 헷갈릴수 있기때문에 권장은x, 더 명시적
        //없어도 되고 기본을 keesun으로 쓰겠다.
        //name option 또한 안써줘도 된다. 되도록이면 화면 name에서 맞추어 주자.
        //@RequestParm은 단순타입을 바인딩할 수 있다.
        Event event = new Event();
        event.setName(name);
        return event;
    }

}
