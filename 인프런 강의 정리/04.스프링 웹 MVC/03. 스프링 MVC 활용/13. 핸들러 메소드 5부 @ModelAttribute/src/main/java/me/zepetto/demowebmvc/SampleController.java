package me.zepetto.demowebmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
    public Event getEvents(@Valid  @ModelAttribute  Event event, BindingResult bindingResult){
        //@ModelAttribute는 복합객체를 받아올수 있고 생략가능하다
        //BindingResult -> 바인딩 관련된 에러를 담아오고 요청은 처리가 가능하다.
        //@Valid에 대한 경우 ,
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
