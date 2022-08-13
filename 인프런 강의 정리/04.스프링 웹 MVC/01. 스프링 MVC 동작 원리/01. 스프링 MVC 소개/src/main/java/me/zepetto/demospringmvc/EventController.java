package me.zepetto.demospringmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EventController {

    @Autowired
    EventService eventService;

    //    @RequestMapping(value ="/events",method= RequestMethod.GET)
    @GetMapping("/events") //Spring 4.3부터 그전에는 아마 security이슈도 있기때문에 버전을 올려서 사용하자.
    public String event(Model model){
        model.addAttribute("events", eventService.getEvents()); //model은 평범한 자바객체 POJO
        return "events";  //view의 이름
    }
}
