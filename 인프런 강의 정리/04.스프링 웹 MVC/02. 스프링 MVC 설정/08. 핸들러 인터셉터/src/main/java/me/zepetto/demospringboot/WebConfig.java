package me.zepetto.demospringboot;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new GreetingInterceptor()).order(0); //순서를 적용할 수 있다.
        registry.addInterceptor(new AnotherInterceptor())
                .addPathPatterns("/hi") //특정 패턴에만 적용하고 싶다
                .order(-1);
    }
}
