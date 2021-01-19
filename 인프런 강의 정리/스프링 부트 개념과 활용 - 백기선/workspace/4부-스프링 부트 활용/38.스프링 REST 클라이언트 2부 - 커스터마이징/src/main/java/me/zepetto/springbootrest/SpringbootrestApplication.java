package me.zepetto.springbootrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.reactive.function.client.WebClientCodecCustomizer;
import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class SpringbootrestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootrestApplication.class, args);
    }

//    @Bean
//    public WebClientCodecCustomizer webClientCodecCustomizer(){
//        //전역적인 설정 방법
//        return new WebClientCodecCustomizer(){
//            @Override
//            public void customize(WebClient.Builder webClientBuilder) {
//                webClientBuilder.baseUrl("http://localhost:8080");
//            }
//        };
//    }

    @Bean
    public RestTemplateCustomizer restTemplateCustomizer(){
        return restTemplate -> restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
    }

}
