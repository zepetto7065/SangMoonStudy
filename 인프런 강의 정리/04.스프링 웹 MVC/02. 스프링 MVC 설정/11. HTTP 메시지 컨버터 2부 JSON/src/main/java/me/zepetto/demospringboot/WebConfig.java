package me.zepetto.demospringboot;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.concurrent.TimeUnit;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new GreetingInterceptor()).order(0); //순서를 적용할 수 있다.
        registry.addInterceptor(new AnotherInterceptor())
                .addPathPatterns("/hi") //특정 패턴에만 적용하고 싶다
                .order(-1);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/mobile/**") // mobile이라고 요청이 들어오면
                .addResourceLocations("classpath:/mobile/") //해당 경로의 resource를 mapping , classpath 말고도 "file:/Users/.
                // .." 파일 기준으로도 찾을수 있다
                .setCacheControl(CacheControl.maxAge(10, TimeUnit.MINUTES)); //10분동안 캐싱을 하겠다. 이외에도 4.1 부터는
        // resourceChain 캐시를 쓸것인가
        // addResolver
        // addTransformer

    }




}
