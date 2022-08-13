package me.zepetto.demobootweb;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
//@WebMvcTest WebMvcTest는 슬라이싱 테스트, Web과 관련된 Bean만 등록
// , Component는 Web과 관련된 Bean이 아니므로 PersonFormatter의 Formatter를 인식하지 못한다.
@SpringBootTest
@AutoConfigureMockMvc // 통합 테스트 진행시 에는 @AutoConfigureMockMvc 를 붙여줌으로써 MockMvc 객체를 사용가능하다.
public class SampleControllerTest {

    @Autowired
    MockMvc mockMvc;

//    @Test
//    public void hello() throws Exception {
//        this.mockMvc.perform(get("/hello/keesun"))
//                .andDo(print())
//                .andExpect(content().string("hello keesun"));
//    }

    @Test
    public void hello() throws Exception { //requestparam 형태로
        this.mockMvc.perform(get("/hello")
                    .param("name", "keesun"))
                .andDo(print())
                .andExpect(content().string("hello keesun"));
    }

}