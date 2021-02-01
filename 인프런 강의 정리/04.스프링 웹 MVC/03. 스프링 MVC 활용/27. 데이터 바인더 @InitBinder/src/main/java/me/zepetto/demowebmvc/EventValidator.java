package me.zepetto.demowebmvc;


import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component // Bean등록해서 써도된다.
public class EventValidator {
//bean으로 등록할떄는 인터페이스 구현을 안해도된다.
//     implements Validator
    //    @Override
//    public boolean supports(Class<?> clazz) {
//        return Event.class.isAssignableFrom(clazz);
//    }

    //커스텀한 Validator
    @Override
    public void validate(Object target, Errors errors) {
        Event event = (Event) target;
        if(event.getName().equalsIgnoreCase("aaa")){
            errors.rejectValue("name","wrongValue", "the value is not allowed");
        }
    }
}
