package me.zepetto.demowebmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.print.attribute.standard.Media;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("event")
public class EventController {

    @ModelAttribute
    public void categories(Model model){
        model.addAttribute("categories", List.of("study", "seminar","hobby","social"));
    }

//    @ModelAttribute("categories")
//    public List<String> categories(Model model){
//        return List.of("study", "seminar","hobby","social");
//    }

    @GetMapping("/events/form/name")
//    @ModelAttribute 이런곳에-> return 값을 model에 담아서 리턴 , 어노테이션 생략가능
    public String eventsFormName(Model model){

        model.addAttribute("event", new Event());
        return "events/form-name";
    }

    @PostMapping("/events/form/name")
    public String createEventsSubmit(@Validated @ModelAttribute  Event event,
                           BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "/events/form-name";
        }
        return "redirect:/events/form/limit";
    }

    @GetMapping("/events/form/limit")
    public String eventsFormLimit(@ModelAttribute Event event, ModelMap model){
        model.addAttribute("event", event);
        return "events/form-limit";
    }

    @PostMapping("/events/form/limit")
    public String createEventsLimitSubmit(@Validated @ModelAttribute  Event event,
                                          BindingResult bindingResult,
                                          SessionStatus sessionStatus,
                                          RedirectAttributes attributes){
        if(bindingResult.hasErrors()){
            return "/events/form-limit";
        }
        sessionStatus.setComplete(); //session 비우기
        attributes.addFlashAttribute("newEvent",event); //redirectAttribute는 문자열만, flashAttribute는 객체도 넘겨줄수 있다.
        //데이터가 세션에 담기고 데이터가 redirect요청이 처리가 되면 세션에서 데이터 삭제
        //세션을 통해 데이터가 전달되기 때문에 URI에 데이터가 노출되지 않는다.
        return "redirect:/events/list"; //get요청을 보낼수 있다. 중복 서브밋 방지.
    }

    @GetMapping("/events/list")
    public String getEvents(
//                            @RequestParam String name ,
//                            @RequestParam Integer limit,
//                            @ModelAttribute("newEvent") Event event,
                            //ModelAttribute 사용시 주의점
                            //@SessionAttributes에서 선언한것과 같은이름을 쓰면 안된다. 세션에 없으면 에러를
                            // 발생시킨다.
                            Model model, // FlashAttribute로 넘어오는 데이터는 Model 로도 바로 들어온다.
                            @SessionAttribute LocalDateTime visitTime){
        System.out.println(visitTime);
//        Event newEvent = new Event();
//        newEvent.setName(name);
//        newEvent.setLimit(limit);
//        Event spring = new Event();
//        spring.setName(event.getName());
//        spring.setLimit(event.getLimit());

        Event newEvent = (Event) model.asMap().get("newEvent");

        List<Event> eventList = new ArrayList<>();
        eventList.add(newEvent);

        model.addAttribute(eventList);

        return "/events/list";
    }

}
