package services.calendar;

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
class CalendarControllerTest {

    @Nested
    public class Script {
        @Autowired
        private MockMvc mockMvc;

        @Test
        public void calendarWorkScriptShouldMakeRequestsWhenUseAllTypesOfRequestAtOnce()
                throws Exception {
            MockHttpServletRequestBuilder requestAddEvent = MockMvcRequestBuilders
                    .post("/calendar/addEvent")
                    .contentType("application/json")
                    .content("{\"year\":2022,\"month\":4,\"day\":14,\"name\":\"A\"}");
            this.mockMvc.perform(requestAddEvent)
                    .andExpect(MockMvcResultMatchers.status().is(200));

            MockHttpServletRequestBuilder requestBuilderAddEventSecond = MockMvcRequestBuilders
                    .post("/calendar/addEvent")
                    .contentType("application/json")
                    .content("{\"year\":2020,\"month\":3,\"day\":11,\"name\":\"C\"}");
            this.mockMvc.perform(requestBuilderAddEventSecond)
                    .andExpect(MockMvcResultMatchers.status().is(200));

            MockHttpServletRequestBuilder requestBuilderAddEventThird = MockMvcRequestBuilders
                    .post("/calendar/addEvent")
                    .contentType("application/json")
                    .content("{\"year\":2022,\"month\":4,\"day\":14,\"name\":\"AA\"}");
            this.mockMvc.perform(requestBuilderAddEventThird)
                    .andExpect(MockMvcResultMatchers.status().is(200));

            MockHttpServletRequestBuilder requestBuilderAddEventFourth = MockMvcRequestBuilders
                    .post("/calendar/addEvent")
                    .contentType("application/json")
                    .content("{\"year\":2020,\"month\":8,\"day\":4,\"name\":\"B\"}");
            this.mockMvc.perform(requestBuilderAddEventFourth)
                    .andExpect(MockMvcResultMatchers.status().is(200));

            MockHttpServletRequestBuilder requestBuilderGetAllEvents = MockMvcRequestBuilders
                    .get("/calendar/allEvents")
                    .contentType("application/json");
            this.mockMvc.perform(requestBuilderGetAllEvents)
                    .andExpect(MockMvcResultMatchers.status().is(200))
                    .andExpect(MockMvcResultMatchers.content().json(
                            "[{\"id\":2, \"year\":2020, \"month\":3, \"day\":11, \"name\":\"C\"}," +
                                    "{\"id\":4, \"year\":2020, \"month\":8, \"day\":4, \"name\":\"B\"}," +
                                    "{\"id\":1, \"year\":2022, \"month\":4, \"day\":14, \"name\":\"A\"},"
                                    + "{\"id\":3, \"year\":2022, \"month\":4, \"day\":14, \"name\":\"AA\"}]"));

            MockHttpServletRequestBuilder requestAddEventFifth = MockMvcRequestBuilders
                    .post("/calendar/addEvent")
                    .contentType("application/json")
                    .content("{\"year\":2001,\"month\":1,\"day\":2,\"name\":\"CC\"}");
            this.mockMvc.perform(requestAddEventFifth)
                    .andExpect(MockMvcResultMatchers.status().is(200));

            MockHttpServletRequestBuilder requestDelete = MockMvcRequestBuilders
                    .delete("/calendar/deleteEvent?id=2")
                    .content("all params");
            this.mockMvc.perform(requestDelete)
                    .andExpect(MockMvcResultMatchers.status().is(200));

            MockHttpServletRequestBuilder requestGetAllEvents = MockMvcRequestBuilders
                    .get("/calendar/allEvents")
                    .contentType("application/json");
            this.mockMvc.perform(requestGetAllEvents)
                    .andExpect(MockMvcResultMatchers.status().is(200))
                    .andExpect(MockMvcResultMatchers.content().json(
                            "[{\"id\":5, \"year\":2001, \"month\":1, \"day\":2, \"name\":\"CC\"}," +
                                    "{\"id\":4, \"year\":2020, \"month\":8, \"day\":4, \"name\":\"B\"},"
                                    + "{\"id\":1, \"year\":2022, \"month\":4, \"day\":14, \"name\"=\"A\"},"
                                    + "{\"id\":3, \"year\":2022, \"month\":4, \"day\":14, \"name\":\"AA\"}]"));

            MockHttpServletRequestBuilder requestAddEventSixth = MockMvcRequestBuilders
                    .post("/calendar/addEvent")
                    .contentType("application/json")
                    .content("{\"year\":2011,\"month\":5,\"day\":25,\"name\":\"FF\"}");
            this.mockMvc.perform(requestAddEventSixth)
                    .andExpect(MockMvcResultMatchers.status().is(200));

            MockHttpServletRequestBuilder requestGetAllEventYear = MockMvcRequestBuilders
                    .get("/calendar/year?year=2022")
                    .contentType("application/json");
            this.mockMvc.perform(requestGetAllEventYear)
                    .andExpect(MockMvcResultMatchers.status().is(200))
                    .andExpect(MockMvcResultMatchers.content().json(
                            "[{\"id\":1, \"year\":2022, \"month\":4, \"day\":14, \"name\":\"A\"},"
                                    + "{\"id\":3, \"year\":2022, \"month\":4, \"day\":14, \"name\":\"AA\"}]"));

            MockHttpServletRequestBuilder requestGetEventYearMonth = MockMvcRequestBuilders
                    .get("/calendar/yearMonth?year=2020&month=8")
                    .contentType("application/json");
            this.mockMvc.perform(requestGetEventYearMonth)
                    .andExpect(MockMvcResultMatchers.status().is(200))
                    .andExpect(MockMvcResultMatchers.content().json(
                            "[{\"id\":4, \"year\":2020, \"month\":8, \"day\":4, \"name\":\"B\"}]"));

            MockHttpServletRequestBuilder requestAddEventSeventh = MockMvcRequestBuilders
                    .post("/calendar/addEvent")
                    .contentType("application/json")
                    .content("{\"year\":2022,\"month\":4,\"day\":25,\"name\":\"JJ\"}");
            this.mockMvc.perform(requestAddEventSeventh)
                    .andExpect(MockMvcResultMatchers.status().is(200));

            MockHttpServletRequestBuilder requestGetEventYearMonthDay = MockMvcRequestBuilders
                    .get("/calendar/yearMonthDay?year=2022&month=4&day=25")
                    .content("all params");
            this.mockMvc.perform(requestGetEventYearMonthDay)
                    .andExpect(MockMvcResultMatchers.status().is(200))
                    .andExpect(MockMvcResultMatchers.content().json(
                            "[{\"id\":7, \"year\":2022, \"month\":4, \"day\":25, \"name\":\"JJ\"}]"));

            MockHttpServletRequestBuilder requestAddEventEight = MockMvcRequestBuilders
                    .post("/calendar/addEvent")
                    .contentType("application/json")
                    .content("{\"year\":2023,\"month\":7,\"day\":2,\"name\":\"GG\"}");
            this.mockMvc.perform(requestAddEventEight)
                    .andExpect(MockMvcResultMatchers.status().is(200));

            MockHttpServletRequestBuilder requestGetAllEventsSecond = MockMvcRequestBuilders
                    .get("/calendar/allEvents")
                    .contentType("application/json");
            this.mockMvc.perform(requestGetAllEventsSecond)
                    .andExpect(MockMvcResultMatchers.status().is(200))
                    .andExpect(MockMvcResultMatchers.content().json(
                            "[{\"id\":5, \"year\":2001, \"month\":1, \"day\":2, \"name\":\"CC\"}," +
                                    "{\"id\":6, \"year\":2011, \"month\":5, \"day\":25, \"name\":\"FF\"}," +
                                    "{\"id\":4, \"year\":2020, \"month\":8, \"day\":4, \"name\":\"B\"}," +
                                    "{\"id\":1, \"year\":2022, \"month\":4, \"day\":14, \"name\":\"A\"}," +
                                    "{\"id\":3, \"year\":2022, \"month\":4, \"day\":14, \"name\":\"AA\"}," +
                                    "{\"id\":7, \"year\":2022, \"month\":4, \"day\":25, \"name\":\"JJ\"}," +
                                    "{\"id\":8, \"year\":2023, \"month\":7, \"day\":2, \"name\":\"GG\"}]"));
        }
    }
}