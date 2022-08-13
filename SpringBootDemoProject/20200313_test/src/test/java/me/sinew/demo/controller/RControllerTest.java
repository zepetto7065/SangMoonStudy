package me.sinew.demo.controller;

import me.sinew.demo.RService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.convert.DurationFormat;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest
class RControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    RService rService;

    @Test
    public void indexTest() throws Exception {
        mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("성공"));
    }


    @Test
    public void postTest() throws Exception {
        String jsonStr = "{\"name\":\"홍길동\", \"age\":20}";

        given(rService.create()).willReturn("3L");

        mockMvc.perform(post("/post")
                .content(jsonStr))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("3L"));
    }







}