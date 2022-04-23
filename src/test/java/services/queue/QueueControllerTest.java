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
    void indexNextTicket() throws Exception{
        MockHttpServletRequestBuilder requestNextTicket = MockMvcRequestBuilders
                .get("/api/queue/nextTicket")
                .contentType("application/json");
        this.mockMvc.perform(requestNextTicket)
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.content().json("{\"number\":1,\"place\":\"'bank'\"}"
                ));
        MockHttpServletRequestBuilder requestSecondNextTicket = MockMvcRequestBuilders
                .get("/api/queue/nextTicket")
                .contentType("application/json");
        this.mockMvc.perform(requestSecondNextTicket)
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.content().json("{\"number\":2,\"place\":\"'bank'\"}"
                ));

        MockHttpServletRequestBuilder requestTotalTickets = MockMvcRequestBuilders
                .get("/api/queue/totalTickets")
                .content("all params");
        this.mockMvc.perform(requestTotalTickets)
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.content().string("2"
                ));


        MockHttpServletRequestBuilder requestNextWorkDay = MockMvcRequestBuilders
                .post("/api/queue/toNextWorkDay")
                .content("all params");
        this.mockMvc.perform(requestNextWorkDay)
                .andExpect(MockMvcResultMatchers.status().is(200));

        MockHttpServletRequestBuilder requestNextTicketSecondDay = MockMvcRequestBuilders
                .get("/api/queue/nextTicket")
                .contentType("application/json");
        this.mockMvc.perform(requestNextTicketSecondDay)
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.content().json("{\"number\":1,\"place\":\"'bank'\"}"
                ));


        MockHttpServletRequestBuilder requestSecondNextTicketSecondDay = MockMvcRequestBuilders
                .get("/api/queue/nextTicket")
                .contentType("application/json");
        this.mockMvc.perform(requestSecondNextTicketSecondDay)
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.content().json("{\"number\":2,\"place\":\"'bank'\"}"
                ));

        MockHttpServletRequestBuilder requestThirdNextTicketSecondDay = MockMvcRequestBuilders
                .get("/api/queue/nextTicket")
                .contentType("application/json");
        this.mockMvc.perform(requestThirdNextTicketSecondDay)
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.content().json("{\"number\":3,\"place\":\"'bank'\"}"
                ));


        MockHttpServletRequestBuilder requestGetVisitsByDays = MockMvcRequestBuilders
                .get("/api/queue/getVisitsByDays")
                .contentType("application/json");
        this.mockMvc.perform(requestGetVisitsByDays)
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.content().json("[2, 3]"
                ));







    }




}