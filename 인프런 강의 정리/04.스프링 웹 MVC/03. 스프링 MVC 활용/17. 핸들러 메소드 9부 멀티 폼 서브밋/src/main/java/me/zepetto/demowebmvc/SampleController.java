package me.zepetto.demowebmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("event")
public class SampleController {

    @GetMapping("/events/form/name")
    public String eventsFormName(Model model){

        model.addAttribute("event", new Event());
        return "events/form-name";
    }

    @PostMapping("/events/form/name")
    public String createEventsSubmit(@Validated @ModelAttribute  Event event, //ModelAttribute는 세션의 객체도 바인딩 받는다.
                           BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "/events/form-name";
        }
        return "redirect:/events/form/limit"; //get요청을 보낼수 있다. 중복 서브밋 방지.
    }

    @GetMapping("/events/form/limit")
    public String eventsFormLimit(@ModelAttribute Event event, Model model){
        model.addAttribute("event", event);
        return "events/form-limit";
    }

    @PostMapping("/events/form/limit")
    public String createEventsLimitSubmit(@Validated @ModelAttribute  Event event,
                                           BindingResult bindingResult,
                                          SessionStatus sessionStatus){
        if(bindingResult.hasErrors()){
            return "/events/form-limit";
        }
        sessionStatus.setComplete(); //session 비우기
        return "redirect:/events/list"; //get요청을 보낼수 있다. 중복 서브밋 방지.
    }

    @GetMapping("/events/list")
    public String getEvents(Model model, @SessionAttribute LocalDateTime visitTime){
        //HttpSession으로 꺼낼 수도 있으나 
        System.out.println(visitTime); //한번 기록된 웹 사이트 기록 시간이 등록
        Event event = new Event();
        event.setName("test입니다.");
        event.setLimit(10);

        List<Event> eventList = new ArrayList<>();
        eventList.add(event);

        model.addAttribute(eventList);

        return "/events/list";
    }

}
