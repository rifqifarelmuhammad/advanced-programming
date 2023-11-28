package id.ac.ui.cs.advprog.tutorial7.leap.year.controller;

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
class LeapYearControllerTest {

        @Autowired
        private MockMvc mockMvc;

        @Test
        void shouldShowPage() throws Exception {
                this.mockMvc.perform(get("/leap-year")).andDo(print()).andExpect(status().isOk())
                                .andExpect(view().name("leap.year/home"))
                                .andExpect(model().attributeExists("dto"));
        }

        @Test
        void year2001() throws Exception {
                this.mockMvc
                                .perform(post("/leap-year")
                                                .param("year", "2001"))
                                .andExpect(content().string(containsString(
                                                "2001 isn&#39;t a leap year because it is not divisible by 4.")));
        }

        @Test
        void year0() throws Exception {
                this.mockMvc
                                .perform(post("/leap-year")
                                                .param("year", "0"))
                                .andExpect(content().string(
                                                containsString("0 is a leap year because it is divisible by 400")));
        }

        @Test
        void year2004() throws Exception {
                this.mockMvc
                                .perform(post("/leap-year")
                                                .param("year", "2004"))
                                .andExpect(content().string(
                                                containsString("2004 is a leap year because it is divisible by 4.")));
        }

        @Test
        void year2010() throws Exception {
                this.mockMvc
                                .perform(post("/leap-year")
                                                .param("year", "2010"))
                                .andExpect(content().string(containsString(
                                                "2010 isn&#39;t a leap year because it is not divisible by 4.")));
        }

        @Test
        void year200() throws Exception {
                this.mockMvc
                                .perform(post("/leap-year")
                                                .param("year", "200"))
                                .andExpect(content().string(containsString(
                                                "200 isn&#39;t a leap year because it is divisible by 100.")));
        }

        @Test
        void year2000() throws Exception {
                this.mockMvc
                                .perform(post("/leap-year")
                                                .param("year", "2000"))
                                .andExpect(content().string(
                                                containsString("2000 is a leap year because it is divisible by 400.")));
        }

        @Test
        void year2012() throws Exception {
                this.mockMvc
                                .perform(post("/leap-year")
                                                .param("year", "2012"))
                                .andExpect(content().string(
                                                containsString("2012 is a leap year because it is divisible by 4.")));
        }
}
