package me.zepetto.springbootrest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

//Client라고 가정
@Component
public class RestRunner implements ApplicationRunner {

    @Autowired
    WebClient.Builder builder;

//    @Autowired
//    RestTemplateBuilder restTemplateBuilder;

    @Override
    public void run(ApplicationArguments args) throws Exception {
//        RestTemplate restTemplate = restTemplateBuilder.build();
        WebClient webClient = builder.build();

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        // TODO /hello
        // 이처리가 끝나기 전까지 다음을 넘어가지않음
//        final String helloResult = restTemplate.getForObject("http://localhost:8080/hello", String.class);
//        System.out.println(helloResult);



        // TODO /world
//        final String worldResult = restTemplate.getForObject("http://localhost:8080/world", String.class);
//        System.out.println(worldResult);


        //위와 다르게 asyncronous 하게 진행되는 코드 WebClient는 Non-Blocking I/O 기반의 API
        //코드는 실제로 쭉 진행이된다. 
        //WebClient를 추천
        //단점이 공부를 해야한다..
        final Mono<String> helloMono = webClient.get().uri("http://localhost:8080/hello")
                .retrieve()
                .bodyToMono(String.class);
        helloMono.subscribe(s -> {
            System.out.println(s);
            if(stopWatch.isRunning()){
                stopWatch.stop();
            }
            System.out.println(stopWatch.prettyPrint());
            stopWatch.start();
        });

        final Mono<String> worldMono = webClient.get().uri("http://localhost:8080/world")
                .retrieve()
                .bodyToMono(String.class);

        worldMono.subscribe(s -> {
            System.out.println(s);
            if(stopWatch.isRunning()){
                stopWatch.stop();
            }
            System.out.println(stopWatch.prettyPrint());
            stopWatch.start();
        });
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
    }
}
