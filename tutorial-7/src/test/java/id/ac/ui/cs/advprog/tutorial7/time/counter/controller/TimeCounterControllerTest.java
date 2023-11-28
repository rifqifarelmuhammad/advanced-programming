package id.ac.ui.cs.advprog.tutorial7.time.counter.controller;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class TimeCounterControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldShowPage() throws Exception {
        this.mockMvc.perform(get("/time-counter")).andDo(print()).andExpect(status().isOk())
                .andExpect(view().name("time.counter/home"))
                .andExpect(model().attributeExists("dto"))
                .andExpect(model().attributeExists("ops"));
    }

    @Test
    void add1921_1059() throws Exception {
        this.mockMvc
                .perform(post("/time-counter")
                        .param("time", "19:21")
                        .param("hours", "10")
                        .param("minutes", "59")
                        .param("operation", "add"))
                .andExpect(content().string(containsString("10 hours 59 minutes after 19:21 is 06:20")));
    }

    @Test
    void add0000_0230() throws Exception {
        this.mockMvc
                .perform(post("/time-counter")
                        .param("time", "00:00")
                        .param("hours", "2")
                        .param("minutes", "30")
                        .param("operation", "add"))
                .andExpect(content().string(containsString("2 hours 30 minutes after 00:00 is 02:30")));
    }

    @Test
    void add0145_0015() throws Exception {
        this.mockMvc
                .perform(post("/time-counter")
                        .param("time", "01:45")
                        .param("hours", "0")
                        .param("minutes", "15")
                        .param("operation", "add"))
                .andExpect(content().string(containsString("15 minutes after 01:45 is 02:00")));
    }

    @Test
    void sub0015_0115() throws Exception {
        this.mockMvc
                .perform(post("/time-counter")
                        .param("time", "00:15")
                        .param("hours", "1")
                        .param("minutes", "15")
                        .param("operation", "subtract"))
                .andExpect(content().string(containsString("1 hour 15 minutes before 00:15 is 23:00")));
    }

    @Test
    void sub1923_0111() throws Exception {
        this.mockMvc
                .perform(post("/time-counter")
                        .param("time", "19:23")
                        .param("hours", "1")
                        .param("minutes", "11")
                        .param("operation", "subtract"))
                .andExpect(content().string(containsString("1 hour 11 minutes before 19:23 is 18:12")));
    }

    @Test
    void sub2323_100100() throws Exception {
        this.mockMvc
                .perform(post("/time-counter")
                        .param("time", "23:23")
                        .param("hours", "100")
                        .param("minutes", "100")
                        .param("operation", "subtract"))
                .andExpect(content().string(containsString("100 hours 100 minutes before 23:23 is 17:43")));
    }

}