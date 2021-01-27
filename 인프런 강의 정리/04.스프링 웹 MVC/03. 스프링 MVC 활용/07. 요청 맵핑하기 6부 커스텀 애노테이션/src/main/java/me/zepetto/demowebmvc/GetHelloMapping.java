package me.zepetto.demowebmvc;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.annotation.*;

@Documented // 이 애노테이션 퍼블릭한 명세에 포함이 되도록 포함시킨다. 어디에? 애노테이션을 사용한 JAVA DOC에
@Target(ElementType.METHOD) //어디에 사용할 수 있는가? -> method에만
//runtime 시 사라지기 때문에 @Retention()를 설정
//구동되는 동안에도 애노테이션 정보를 유지를 해달라고 적어준다.
@Retention(RetentionPolicy.RUNTIME)
@RequestMapping(value = "/hello",method = RequestMethod.GET)
public @interface GetHelloMapping {

}
