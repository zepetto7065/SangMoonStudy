package me.zepetto.demowebmvc;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//이벤트를 만들거나 수정하는 용도
@Controller
@RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE
,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class EventUpdateController {

    @PostMapping(value = "/events")
    @ResponseBody
    public String createEvents(){
        return "events";
    }
    @PutMapping(value = "/events")
    @ResponseBody
    public String updateEvents(){
        return "events";
    }

}
