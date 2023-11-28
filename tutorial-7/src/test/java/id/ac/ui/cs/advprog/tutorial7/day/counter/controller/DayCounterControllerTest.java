package id.ac.ui.cs.advprog.tutorial7.day.counter.controller;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class DayCounterControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldShowPage() throws Exception {
        this.mockMvc.perform(get("/day-counter")).andDo(print()).andExpect(status().isOk())
                .andExpect(view().name("day.counter/home"))
                .andExpect(model().attributeExists("days"))
                .andExpect(model().attributeExists("dto"));
    }

    @Test
    void sundayPlus1() throws Exception {
        this.mockMvc
                .perform(post("/day-counter")
                        .param("day", "Sunday")
                        .param("n", "1"))
                        .andExpect(content().string(containsString("1 day(s) in the future after Sunday is Monday.")));
    }

    @Test
    void wednesdayPlus100() throws Exception {
        this.mockMvc
                .perform(post("/day-counter")
                        .param("day", "Wednesday")
                        .param("n", "100"))
                .andExpect(content().string(containsString("100 day(s) in the future after Wednesday is Friday.")));
    }

    @Test
    void saturdayMin60() throws Exception {
        this.mockMvc
                .perform(post("/day-counter")
                        .param("day", "Saturday")
                        .param("n", "-60"))
                .andExpect(content().string(containsString("60 day(s) ago before Saturday was Tuesday.")));
    }

    @Test
    void mondayPlus0() throws Exception {
        this.mockMvc
                .perform(post("/day-counter")
                        .param("day", "Monday")
                        .param("n", "0"))
                .andExpect(content().string(containsString("0 day(s) in the future after Monday is Monday.")));
    }

    @Test
    void thursdayMin3() throws Exception {
        this.mockMvc
                .perform(post("/day-counter")
                        .param("day", "Thursday")
                        .param("n", "-3"))
                .andExpect(content().string(containsString("3 day(s) ago before Thursday was Monday.")));
    }
}

