package me.zepetto.demowebmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

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
    public String getEvents(Model model){
        // 이부분에서 list data를 가져와야하는데 테스트상.
        Event event = new Event();
        event.setName("test입니다.");
        event.setLimit(10);

        List<Event> eventList = new ArrayList<>();
        eventList.add(event);

        model.addAttribute(eventList);

        return "/events/list";
    }

}
