package services.queue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc

class QueueControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void indexApiSecond() throws Exception{
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get("/api/queue/nextTicket")
                .content("all params");
        this.mockMvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.content().string("Ticket{number="+1+", place=bank}"
                ));
        MockHttpServletRequestBuilder requestSecond = MockMvcRequestBuilders
                .get("/api/queue/nextTicket")
                .content("all params");
        this.mockMvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.content().string("Ticket{number="+2+", place=bank}"
                ));
    }

}