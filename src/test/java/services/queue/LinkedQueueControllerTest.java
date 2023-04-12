package services.queue;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class LinkedQueueControllerTest {
    @Nested
    public class Script {
        @Autowired
        private MockMvc mockMvc;

        @Test
        void scriptShouldMakeRequestsWhenUseAllTypesOfRequestAtOnce()
                throws Exception {


            MockHttpServletRequestBuilder requestNextTicket = MockMvcRequestBuilders
                    .get("/api/queue/nextTicket")
                    .contentType("application/json");
            this.mockMvc.perform(requestNextTicket)
                    .andExpect(MockMvcResultMatchers.status().is(200))
                    .andExpect(MockMvcResultMatchers.content().json("{\"number\":1,\"place\":\"bank\"}"
                    ));
            MockHttpServletRequestBuilder requestSecondNextTicket = MockMvcRequestBuilders
                    .get("/api/queue/nextTicket")
                    .contentType("application/json");
            this.mockMvc.perform(requestSecondNextTicket)
                    .andExpect(MockMvcResultMatchers.status().is(200))
                    .andExpect(MockMvcResultMatchers.content().json("{\"number\":2,\"place\":\"bank\"}"
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
                    .andExpect(MockMvcResultMatchers.content().json("{\"number\":1,\"place\":\"bank\"}"
                    ));

            MockHttpServletRequestBuilder requestSecondNextTicketSecondDay = MockMvcRequestBuilders
                    .get("/api/queue/nextTicket")
                    .contentType("application/json");
            this.mockMvc.perform(requestSecondNextTicketSecondDay)
                    .andExpect(MockMvcResultMatchers.status().is(200))
                    .andExpect(MockMvcResultMatchers.content().json("{\"number\":2,\"place\":\"bank\"}"
                    ));

            MockHttpServletRequestBuilder requestThirdNextTicketSecondDay = MockMvcRequestBuilders
                    .get("/api/queue/nextTicket")
                    .contentType("application/json");
            this.mockMvc.perform(requestThirdNextTicketSecondDay)
                    .andExpect(MockMvcResultMatchers.status().is(200))
                    .andExpect(MockMvcResultMatchers.content().json("{\"number\":3,\"place\":\"bank\"}"
                    ));

            MockHttpServletRequestBuilder requestGetVisitsByDays = MockMvcRequestBuilders
                    .get("/api/queue/getVisitsByDays")
                    .contentType("application/json");
            this.mockMvc.perform(requestGetVisitsByDays)
                    .andExpect(MockMvcResultMatchers.status().is(200))
                    .andExpect(MockMvcResultMatchers.content().json("[2, 3]"
                    ));

            MockHttpServletRequestBuilder requestNextWorkDaySecond = MockMvcRequestBuilders
                    .post("/api/queue/toNextWorkDay")
                    .content("all params");
            this.mockMvc.perform(requestNextWorkDaySecond)
                    .andExpect(MockMvcResultMatchers.status().is(200));

            MockHttpServletRequestBuilder requestNextTicket5 = MockMvcRequestBuilders
                    .get("/api/queue/nextTicket")
                    .contentType("application/json");
            this.mockMvc.perform(requestNextTicket)
                    .andExpect(MockMvcResultMatchers.status().is(200))
                    .andExpect(MockMvcResultMatchers.content().json("{\"number\":1,\"place\":\"bank\"}"
                    ));
            MockHttpServletRequestBuilder requestSecondNextTicket6 = MockMvcRequestBuilders
                    .get("/api/queue/nextTicket")
                    .contentType("application/json");
            this.mockMvc.perform(requestSecondNextTicket)
                    .andExpect(MockMvcResultMatchers.status().is(200))
                    .andExpect(MockMvcResultMatchers.content().json("{\"number\":2,\"place\":\"bank\"}"
                    ));

            MockHttpServletRequestBuilder callNext = MockMvcRequestBuilders
                    .post("/api/queue/callNext")
                    .content("all params");
            this.mockMvc.perform(callNext)
                    .andExpect(MockMvcResultMatchers.status().is(200));

            MockHttpServletRequestBuilder getCurrentQueue = MockMvcRequestBuilders
                    .get("/api/queue/getCurrentQueue")
                    .contentType("application/json");
            this.mockMvc.perform(getCurrentQueue)
                    .andExpect(MockMvcResultMatchers.status().is(200))
                    .andExpect(MockMvcResultMatchers.content().json("[{\"number\":2,\"place\":\"bank\"}]"
                    ));

        }


        @Test
        void scriptShouldMakeNextTicketCallNextGetCurrentQueueWhenUseAllTypesOfRequestAtOnce() throws Exception {
            MockHttpServletRequestBuilder requestNextTicket = MockMvcRequestBuilders
                    .get("/api/queue/nextTicket")
                    .contentType("application/json");
            this.mockMvc.perform(requestNextTicket)
                    .andExpect(MockMvcResultMatchers.status().is(200))
                    .andExpect(MockMvcResultMatchers.content().json("{\"number\":1,\"place\":\"bank\"}"
                    ));
            MockHttpServletRequestBuilder requestSecondNextTicket = MockMvcRequestBuilders
                    .get("/api/queue/nextTicket")
                    .contentType("application/json");
            this.mockMvc.perform(requestSecondNextTicket)
                    .andExpect(MockMvcResultMatchers.status().is(200))
                    .andExpect(MockMvcResultMatchers.content().json("{\"number\":2,\"place\":\"bank\"}"
                    ));

            MockHttpServletRequestBuilder callNext = MockMvcRequestBuilders
                    .post("/api/queue/callNext");
            this.mockMvc.perform(callNext)
                    .andExpect(MockMvcResultMatchers.status().is(200))
                    .andExpect(MockMvcResultMatchers.content().json("{\"number\":1,\"place\":\"bank\"}"
                    ));

            MockHttpServletRequestBuilder getCurrentQueue = MockMvcRequestBuilders
                    .get("/api/queue/getCurrentQueue")
                    .contentType("application/json");
            this.mockMvc.perform(getCurrentQueue)
                    .andExpect(MockMvcResultMatchers.status().is(200))
                    .andExpect(MockMvcResultMatchers.content().json("[{\"number\":2,\"place\":\"bank\"}]"
                    ));

            MockHttpServletRequestBuilder requestNextWorkDay = MockMvcRequestBuilders
                    .post("/api/queue/toNextWorkDay")
                    .content("all params");
            this.mockMvc.perform(requestNextWorkDay)
                    .andExpect(MockMvcResultMatchers.status().is(200));

        }

        @Test
        public void shouldReturn405StatusWhenUserCallsOnlyCallNext() throws Exception {
            MockHttpServletRequestBuilder callNext = MockMvcRequestBuilders
                    .post("/api/queue/callNext");

            this.mockMvc.perform(callNext)
                    .andExpect(MockMvcResultMatchers.status().is(404));

        }


    }
}
