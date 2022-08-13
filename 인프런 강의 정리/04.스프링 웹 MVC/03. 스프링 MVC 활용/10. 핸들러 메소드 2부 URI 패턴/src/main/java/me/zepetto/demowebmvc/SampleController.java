package me.zepetto.demowebmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class SampleController {

    @GetMapping("/events/{id}")
    @ResponseBody
    public Event events(@PathVariable Integer id, @MatrixVariable String name){
        Event event = new Event();
        event.setId(id);
        event.setName(name);
        return event;
    }

}
