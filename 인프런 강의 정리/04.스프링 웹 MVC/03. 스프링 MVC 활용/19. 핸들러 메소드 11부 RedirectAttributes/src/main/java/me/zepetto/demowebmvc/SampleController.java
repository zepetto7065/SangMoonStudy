package me.zepetto.demowebmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String createEventsSubmit(@Validated @ModelAttribute  Event event,
                           BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "/events/form-name";
        }
        return "redirect:/events/form/limit";
    }

    @GetMapping("/events/form/limit")
    public String eventsFormLimit(@ModelAttribute Event event, Model model){
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
        attributes.addAttribute("name", event.getName());
        attributes.addAttribute("limit", event.getLimit());
//        model.addAttribute("name",event.getName());
//        model.addAttribute("limit",event.getLimit());
        //model에 담아 redirect할 경우 객체의 primitive 타입 String , Integer는 events/list?name=keesun&limit=30이런식으로 붙는다
        //spring boot는 이기능을 자동으로 꺼놨다. WebMvcAutoConfiguration
        //spring.mvc.ignore-default-model-on-redirect=false -> 자동으로 쿼리 파라미터 받도록 해준다.
        //redirect한 events/list 쪽에서 @RequestParam 등을 이용하여 가져다 사용할 수 있다. (@PathVariable  x 이건 URI 경로 )
        //그런데 모델 모든 데이터 말고, 일부만 명시적으로 보내고 싶을 때 Model 대신 RedirectAttributes
        //이때는 스프링 기본설정 spring.mvc.ignore-default-model-on-redirect=false 삭제
        return "redirect:/events/list"; //get요청을 보낼수 있다. 중복 서브밋 방지.
    }

    @GetMapping("/events/list")
    public String getEvents(
//                            @RequestParam String name ,
//                            @RequestParam Integer limit,
                            @ModelAttribute("newEvent") Event event,
                            //ModelAttribute 사용시 주의점
                            //@SessionAttributes에서 선언한것과 같은이름을 쓰면 안된다. 세션에 없으면 에러를
                            // 발생시킨다.
                            Model model,
                            @SessionAttribute LocalDateTime visitTime){
        System.out.println(visitTime);
//        Event newEvent = new Event();
//        newEvent.setName(name);
//        newEvent.setLimit(limit);
        Event spring = new Event();
        spring.setName(event.getName());
        spring.setLimit(event.getLimit());

        List<Event> eventList = new ArrayList<>();
        eventList.add(spring);

        model.addAttribute(eventList);

        return "/events/list";
    }

}
