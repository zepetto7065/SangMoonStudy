package me.zepetto.springtestdemo;

import me.zepetto.springtestdemo.sample.SampleController;
import me.zepetto.springtestdemo.sample.SampleService;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK) //MOCK이 아닌 RANDOM_PORT 일떄 , TestRestTemplate을
// 사용해야한다.
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
// @JsonTest - JsonData,@WebMvcTest  - 컨트롤러 하나만,
@AutoConfigureMockMvc // servlet 컨테이너에 테스트용으로 띄우지않고
public class SpringtestdemoApplicationTests {

    @Rule
    public OutputCapture outputCapture = new OutputCapture(); //log를 포함 콘솔에 찍히는 모든걸 캡쳐

    @Autowired
//    MockMvc mockMvc; //@SpringBootTest-WebEnviroment.Mock , @WebMvcTest
//    TestRestTemplate testRestTemplate;
            WebTestClient webTestClient; //web-flux에 있는 클라이언트를 사용하자

    @MockBean
    SampleService mockSampleService;

    @Test
    public void hello() {
        when(mockSampleService.getName()).thenReturn("sangmoon");

        webTestClient.get().uri("/hello").exchange()
                .expectStatus().isOk()
                .expectBody(String.class).isEqualTo("hello sangmoon");
    }

//    @Test
//    public void hello(){
//        when(mockSampleService.getName()).thenReturn("sangmoon");
//
//        String result = testRestTemplate.getForObject("/hello", String.class);
//        assertThat(result).isEqualTo("hello sangmoon");
//    }

//    @Test
//    public void hello() throws Exception {
//        mockMvc.perform(get("/hello"))
//                .andExpect(status().isOk())
//                .andExpect(content().string("hello sangmoon"))
//                .andDo(print());
//    }


}
