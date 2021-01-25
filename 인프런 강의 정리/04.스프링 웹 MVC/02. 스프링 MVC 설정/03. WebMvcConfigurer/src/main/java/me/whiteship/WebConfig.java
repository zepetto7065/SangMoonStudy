package me.whiteship;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        //view resolver를 등록하지 않아도 같은 결과를 가져올 수 있다.
        registry.jsp("/WEB-INF/", ".jsp");

    }
    
    //formatter, interceptor를 여기서 손쉽게 추가 가능
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

    }

    @Override
    public void addFormatters(FormatterRegistry registry) {

    }

}
