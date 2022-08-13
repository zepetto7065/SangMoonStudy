package me.zepetto.demowebmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("event") // 자동으로 해당 세션에 Model객체와 동일한 이름이 있다면 Model 객체를 넣어준다.
//가령 입력 값이 너무 많은 경우, 화면을 나눈다 , 즉 화면별로 입력받은 입력값들을 세션에 저장해서 재사용하곤한다.
//@SessionStatus 는 Method 아규먼트를 지정해서 받을 수 있다.
public class SampleController {

    @GetMapping("/events/form")
    public String eventsForm(Model model, HttpSession httpSession){
        Event newEvent = new Event();
        newEvent.setLimit(50);
        model.addAttribute("event", newEvent);
//        httpSession.setAttribute("event", newEvent);
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
