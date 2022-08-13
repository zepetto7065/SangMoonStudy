package me.zepetto.demowebmvc;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
@EnableWebMvc
// 붙이는 순간 사용할 수 있는 설정 파일 (DelegationWebMVC) 클래스의 기본 컨버터로 등록이 되는 메소드를
// 핸들러 어댑터 들이 사용하는데 핸들러 어댑터 안에 요청을 컨버팅할 수 있는 여러 HTTP 컨버터등 중 하나를 선택해서 사용
public class WebConfig implements WebMvcConfigurer {

    //원하는 컨버터를 추가할 수 있다.
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {

    }
}
