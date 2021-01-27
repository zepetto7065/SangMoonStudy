package me.zepetto.demowebmvc;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class SampleController {

    @GetMapping("/events")
    @ResponseBody
    public String getEvents(){
        return "events";
    }

    @GetMapping("/events/{id}")
    @ResponseBody
    public String getEvents(@PathVariable int id){
        return "events " + id;
    }


    @DeleteMapping("/events/{id}")
    @ResponseBody
    public String deleteEvents(@PathVariable int id){
        return "delete Events";
    }



}
