package me.zepetto.springtestdemo.sample;


import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
//@WebMvcTest(SanmpleController.class) //클라이언트 하나만 ,web과 관련한 것만 빈으로 등록되고 일반적 컴포넌트(service)등이 등록되지 않는다.
//사용하는 의존성이 있다면 MockBean으로 채워 주어야한다. WebMvcTest는 MockBean으로 테스트
//@JsonTest //json data test용ㅈ
//이외에도 @WebFluxTest, @DataJpaTest등이 있다.
public class SlicingTest {

    @MockBean
    SampleService sampleService;

    //    @Autowired
////    JacksonTester<도메인>

    @Autowired
    MockMvc mockMvc;

    //console 캡쳐하여 Test 가능
    @Test
    public void hello() throws Exception {
        when(sampleService.getName()).thenReturn("whiteShip");

        mockMvc.perform(get("/hello"))
                .andExpect(content().string("hello whiteship"));
    }
}
