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

    @PostMapping
//    @ResponseBody //HttpMessageConverter 사용해서 응답본문에 담아준다.
//    //RestController 사용시 , 생략이 가능하다.
    //ResponseEntity 사용하면 Response Body에 객체를 넣어줄 수 있다. 직접 헤더와 본문을 다루고 싶을때 사용
    public ResponseEntity<Event> createEvent(@RequestBody @Valid Event event, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return ResponseEntity.badRequest().build(); //본문에 메세지를 넣어줄 수 있다.
        }

//        return ResponseEntity.ok(event); //event를 ResponseBody 객체에 넣어준다.
        return new ResponseEntity<Event>(event,HttpStatus.CREATED); //세밀한 응답 코드 설정 가능
    }

}
