package services.calculation;

import org.junit.jupiter.api.Nested;
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
class CalculationControllerTest {

    @Nested
    public class Operation {
        @Autowired
        private MockMvc mockMvc;

        @Test
        public void shouldReturnNumberWhenUseOperatorPlus() throws Exception {
            MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                    .get("/calculation?term1=2&operator=PLUS&term2=3")
                    .contentType("application/json");
            this.mockMvc.perform(request)
                    .andExpect(MockMvcResultMatchers.status().is(200))
                    .andExpect(MockMvcResultMatchers.content().json("5"));

        }

        @Test
        public void shouldReturnNumberWhenUseOperatorMinus() throws Exception {
            MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                    .get("/calculation?term1=2&operator=MINUS&term2=3")
                    .contentType("application/json");
            this.mockMvc.perform(request)
                    .andExpect(MockMvcResultMatchers.status().is(200))
                    .andExpect(MockMvcResultMatchers.content().json("-1"));
        }

        @Test
        public void shouldReturnNumberWhenUseOperatorMultiply() throws Exception {
            MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                    .get("/calculation?term1=2&operator=MULTIPLY&term2=3")
                    .contentType("application/json");
            this.mockMvc.perform(request)
                    .andExpect(MockMvcResultMatchers.status().is(200))
                    .andExpect(MockMvcResultMatchers.content().json("6"));
        }

        @Test
        public void shouldReturnNumberWhenUseOperatorDivide() throws Exception {
            MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                    .get("/calculation?term1=3&operator=DIVIDE&term2=3")
                    .contentType("application/json");
            this.mockMvc.perform(request)
                    .andExpect(MockMvcResultMatchers.status().is(200))
                    .andExpect(MockMvcResultMatchers.content().json("1"));
        }
    }

    @Nested
    public class ReturnOperators {
        @Autowired
        private MockMvc mockMvc;

        @Test
        public void shouldReturnOperatorsWhenUseRequestOperators() throws Exception {
            MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                    .get("/operators")
                    .contentType("application/json");
            this.mockMvc.perform(request)
                    .andExpect(MockMvcResultMatchers.status().is(200))
                    .andExpect(MockMvcResultMatchers.content().json("[\"PLUS\", \"MINUS\", \"MULTIPLY\", \"DIVIDE\"]"));

        }
    }
}