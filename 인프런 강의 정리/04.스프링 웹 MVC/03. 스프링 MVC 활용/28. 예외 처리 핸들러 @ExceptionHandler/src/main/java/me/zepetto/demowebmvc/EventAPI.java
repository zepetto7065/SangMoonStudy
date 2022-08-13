package me.zepetto.demowebmvc;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/api/events")
public class EventAPI {

    //REST API의 경우 응답값에 전달해야하므로
    // ResponseEntity를 주로 사용한다.
    @ExceptionHandler
    public ResponseEntity errorHandler(){
        return ResponseEntity.badRequest().body("can`t create event as...");
    }


    @PostMapping
    public ResponseEntity<Event> createEvent(@RequestBody @Valid Event event, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return ResponseEntity.badRequest().build(); //본문에 메세지를 넣어줄 수 있다.
        }

//        return ResponseEntity.ok(event); //event를 ResponseBody 객체에 넣어준다.
        return new ResponseEntity<Event>(event,HttpStatus.CREATED); //세밀한 응답 코드 설정 가능
    }

}
