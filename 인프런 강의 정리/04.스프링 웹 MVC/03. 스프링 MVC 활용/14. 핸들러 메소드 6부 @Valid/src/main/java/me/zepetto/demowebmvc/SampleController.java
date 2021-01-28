package me.zepetto.demowebmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
public class SampleController {

    @GetMapping("/events/form")
    public String eventsForm(Model model){
        Event newEvent = new Event();
        newEvent.setLimit(50);
        model.addAttribute("event", newEvent);
        return "events/form";
    }

    @PostMapping("/events/name/{name}")
    @ResponseBody
    public Event getEvents(@Validated(Event.ValidateLimit.class) @ModelAttribute  Event event,
                           BindingResult bindingResult){
        //@Validated는 @Valid르 덤으로 그룹설정 가능하다.
        if(bindingResult.hasErrors()){
            System.out.println("===========================");
            bindingResult.getAllErrors().forEach(c->{
                System.out.println(c.toString());
            });
            System.out.println("===========================");
        }
       return event;
    }

}
