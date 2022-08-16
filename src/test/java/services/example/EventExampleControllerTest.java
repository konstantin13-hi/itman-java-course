package services.example;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class EventExampleControllerTest {

    @Nested
    public class Script {
        @Autowired
        private MockMvc mockMvc;

        @Test
        void shouldExecutedWith200AndReturnNumbersWhenUseGetAndPostRequests() throws Exception {
            MockHttpServletRequestBuilder requestPost = MockMvcRequestBuilders
                    .post("/api/event")
                    .contentType("application/json")
                    .content("{\"day\":14,\"year\":2022,\"month\":4,\"name\":\"Json\"}");
            this.mockMvc.perform(requestPost)
                    .andExpect(MockMvcResultMatchers.status().is(200));


            MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                    .get("/api/event")
                    .contentType("application/json");
            this.mockMvc.perform(request)
                    .andExpect(MockMvcResultMatchers.status().is(200))
                    .andExpect(MockMvcResultMatchers.content().json(
                            "{\"day\":14,\"year\":2022,\"month\":4,\"name\":\"Json\"}"));


        }

        @Test
        void shouldExecutedWith200AndReturnNumbersWhenUseGetAndPostRequestsWhereContentHaveNull() throws Exception {
            MockHttpServletRequestBuilder requestPost = MockMvcRequestBuilders
                    .post("/api/event")
                    .contentType("application/json")
                    .content("{\"day\":14,\"year\":2022,\"month\":4,\"name\":null}");
            this.mockMvc.perform(requestPost)
                    .andExpect(MockMvcResultMatchers.status().is(200));


            MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                    .get("/api/event")
                    .contentType("application/json");
            this.mockMvc.perform(request)
                    .andExpect(MockMvcResultMatchers.status().is(200))
                    .andExpect(MockMvcResultMatchers.content().json(
                            "{\"day\":14,\"year\":2022,\"month\":4,\"name\":null}"));
        }
    }
}