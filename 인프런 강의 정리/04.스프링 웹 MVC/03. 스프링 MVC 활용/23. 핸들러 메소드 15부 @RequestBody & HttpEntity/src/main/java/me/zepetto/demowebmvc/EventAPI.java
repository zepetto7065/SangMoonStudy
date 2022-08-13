package me.zepetto.demowebmvc;

import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/events")
public class EventAPI {

    @PostMapping
//    public Event createEvent(@RequestBody Event event){ //BODY 정보만 가져올떄
//    public Event createEvent(@RequestBody HttpEntity<Event> request){ // Request 본문을 가져올떄 가져올떄
//    public Event createEvent( HttpEntity<Event> Eventrequest){ // @RequestBody를 빼면 헤더정보도 가져온다.
    //@RequestParam 과 같은 효과,바인딩 에러를 소스에서 처리할 수 있다. 400에러를 발생시키진않고 소스에서 처리해야한다.
    public Event createEvent(@RequestBody @Valid Event event, BindingResult bindingResult){

        //save Event
//        return event;

//        return request.getBody();

//        final MediaType contentType = request.getHeaders().getContentType();
//        System.out.println(contentType);
//        return request.getBody();

        if(bindingResult.hasErrors()){
            bindingResult.getAllErrors().forEach(error -> {
                System.out.println(error);
            });
        }
        return event;

    }

}
