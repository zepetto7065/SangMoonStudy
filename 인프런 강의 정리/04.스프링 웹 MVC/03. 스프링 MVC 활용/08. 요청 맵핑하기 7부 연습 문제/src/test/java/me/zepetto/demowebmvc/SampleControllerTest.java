package me.zepetto.demowebmvc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
public class SampleControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void getEvents() throws Exception{
        mockMvc.perform(get("/events"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getEventsWithId() throws Exception{
        mockMvc.perform(get("/events/1"))
                .andDo(print())
                .andExpect(status().isOk());
        mockMvc.perform(get("/events/2"))
                .andDo(print())
                .andExpect(status().isOk());
        mockMvc.perform(get("/events/3"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void createEvent() throws Exception {
        mockMvc.perform(post("/events")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void deleteEvent() throws Exception {
        mockMvc.perform(delete("/events/1"))
                .andExpect(status().isOk());
        mockMvc.perform(delete("/events/2"))
                .andExpect(status().isOk());
        mockMvc.perform(delete("/events/3"))
                .andExpect(status().isOk());
    }
    @Test
    public void putEvent() throws Exception {
        mockMvc.perform(put("/events")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk());
    }




}
