package me.zepetto.demospringmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EventController {

    @Autowired
    EventService eventService;

    @GetMapping("/events")
    public String event(Model model){
        model.addAttribute("events", eventService.getEvents());
        return "events";  //view의 이름
    }
}
