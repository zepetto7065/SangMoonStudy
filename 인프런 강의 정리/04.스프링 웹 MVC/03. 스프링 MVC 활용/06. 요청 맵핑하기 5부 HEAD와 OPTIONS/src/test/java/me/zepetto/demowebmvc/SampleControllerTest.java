package me.zepetto.demowebmvc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
public class SampleControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void helloTest() throws Exception {
//           mockMvc.perform(head("/hello")
//                .param("name", "keesun"))
//                .andDo(print())
//                .andExpect(status().isOk());

        //spring mvc 가 기본적으로 제공해주는 options는 직접 구현할 필요없이 http 목록 제공
           mockMvc.perform(options("/hello"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(header().stringValues(HttpHeaders.ALLOW,
                        hasItems(
                                containsString("GET"),
                                containsString("POST"),
                                containsString("HEAD"),
                                containsString("OPTIONS")
                        )));
    }
}
