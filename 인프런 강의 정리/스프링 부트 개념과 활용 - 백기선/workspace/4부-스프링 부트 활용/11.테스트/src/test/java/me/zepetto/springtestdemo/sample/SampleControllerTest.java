package me.zepetto.springtestdemo.sample;


import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@RunWith(SpringRunner.class)
@WebMvcTest(SampleController.class)
//통합테스트
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) //실제 서블릿 컨테이너(내장톰캣)이 올라간다. (
// DEFINED_PORT 보다도 RANDOM 추천 )
//따라서 test용 restTemplate - assertThat 나 WebClient를 사용해야한다.
//내장 톰캣을 쓰면 좋지만 너무 크다.. @MockBean을 이용하여 Service Bean을 MockBean으로 교체 가능하다. 즉, 원본이 아니다.
//WebTestClient는 SpringMVCwebFlux에 추가된 RestClient중에 하나 , asyncronous -> 응답 보내면 바로 콜백이 온다. , 사용하려면 dependency 추가를 해줄것
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class SampleControllerTest {
    @Rule
    public OutputCapture outputCapture = new OutputCapture();

    @MockBean
    SampleService mockSampleService;

    @Autowired
    MockMvc mockMvc; //Mock Test 가능


    //console 캡쳐하여 Test 가능
    @Test
    public void hello() throws Exception {
        when(mockSampleService.getName()).thenReturn("sangmoon");

        mockMvc.perform(get("/hello"))
                .andExpect(content().string("hello sangmoon"));
        assertThat(outputCapture.toString())
                .contains("holoman")
                .contains("skip");

        //webTestClien.get().uri("/").exchange().expectStatus().isOk()
        //              .expectBody(String.class).isEqualTo("hello whiteship")
        //이거 쓰려고 webflux 추가한다 . 그럴만할 가치가 있다고함..


    }
}
