package me.zepetto.demowebmvc;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

//@RestContollerAdvice 도 있다. 굳이...
@ControllerAdvice(assignableTypes = EventController.class) // 전역 컨트롤러, EventController에만 적용 가능
public class BaseController {

    //    @ExceptionHandler({EventException.class, RuntimeException.class}) //여러개 발생할 경우
    @ExceptionHandler
    public String eventErrorHandler(RuntimeException exception, Model model){
        model.addAttribute("message", "event error");
        return "files/error";
    }

    //모든 요청 전에 IntiBinder 호출
//    @InitBinder("event") //문자열을 입력하면 해당 문자열을 요청받을 때만 InitBinder 사용가능하다.
    @InitBinder
    public void initEventBinder(WebDataBinder webDataBinder){
        webDataBinder.setDisallowedFields("id"); // id값을 바인딩 받고 싶지 않을때, 보안상 안전하다.
        webDataBinder.addValidators(new EventValidator());
    }

    @ModelAttribute
    public void categories(Model model){
        model.addAttribute("categories", List.of("study", "seminal", "hobby"));
    }


}
