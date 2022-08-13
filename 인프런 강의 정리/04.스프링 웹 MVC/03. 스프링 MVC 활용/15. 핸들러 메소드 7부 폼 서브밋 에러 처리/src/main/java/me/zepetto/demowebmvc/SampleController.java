package me.zepetto.demowebmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SampleController {

    @GetMapping("/events/form")
    public String eventsForm(Model model){
        Event newEvent = new Event();
        newEvent.setLimit(50);
        model.addAttribute("event", newEvent);
        return "events/form";
    }

    @PostMapping("/events")
    public String createEvents(@Validated @ModelAttribute  Event event,
                           BindingResult bindingResult,
                            Model model){
        if(bindingResult.hasErrors()){
            return "/events/form";
        }

//        List<Event> eventList = new ArrayList<>();
//        eventList.add(event);
//        model.addAttribute(eventList);//이름을 같게하려면 다음 표기도 무관하다.
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
