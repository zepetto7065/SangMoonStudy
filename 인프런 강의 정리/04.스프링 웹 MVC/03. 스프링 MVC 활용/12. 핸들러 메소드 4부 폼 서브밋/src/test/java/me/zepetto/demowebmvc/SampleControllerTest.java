package me.zepetto.demowebmvc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest
public class SampleControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void eventForm() throws Exception {
        mockMvc.perform(post("/events/form"))
                .andDo(print())
                .andExpect(view().name("/events/form")) //화면 이름이 해당 이름인가?
                .andExpect(model().attributeExists("event")) //event 라는 객체를 가지고 있는가?
                ;
        //타임리프의 경우 , 렌더링이 서블릿 컨테이너 엔진 없어도 서버사이드에서 끝나기 때문에 뷰의 결과를 확인 가능하다 (jsp 안된다. )

    }

    @Test
    public void postEvent() throws Exception {
        mockMvc.perform(post("/events")
                    .param("name","keesun")
                    .param("limit","20")) //문자열을 주어도 Integer로 타입변환이 된다.
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("name").value("keesun")); //event를 json으로
    }



}
