package services.example;

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

class ExampleControllerTest {
    @Autowired
    private MockMvc mockMvc;


    @Test
    public void shouldExecutedWith200WhenPassAllParams() throws Exception {
        final MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post("/extract/one/1?required=r&optional=opt&default=0&missing=world")
                .content("all params");
        this.mockMvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("" +
                        "pathVariable = one\n" +
                        "second = 1\n" +
                        "required = r\n" +
                        "optional = opt\n" +
                        "default = 0\n" +
                        "body = all params\n"
                ));
    }


    @Test
    public void shouldExecutedWith200WhenPassOnlyRequired() throws Exception {
        final MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post("/extract/two/2?required=r&missing=world")
                .content("only required");
        this.mockMvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("" +
                        "pathVariable = two\n" +
                        "second = 2\n" +
                        "required = r\n" +
                        "optional = null\n" +
                        "default = -1\n" +
                        "body = only required\n"
                ));
    }

    @Test
    public void shouldExecutedWith200WhenPassMissingRequired() throws Exception {
        final MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post("/extract/three/3?missing=world")
                .content("missing required");
        this.mockMvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().is(400))
                .andExpect(MockMvcResultMatchers.content().string(""


                ));
    }

    @Test
    void index() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post("/")
                .content("I'm your first web-service");
        this.mockMvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().is(405))
                .andExpect(MockMvcResultMatchers.content().string(""
                ));
    }

    @Test
    void indexSecond() throws Exception  {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post("/second")
                .content("I'm the second binding");
        this.mockMvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.content().string("I'm post mapping"
                ));
    }


    @Test
    void indexPost() throws Exception{
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post("/second")
                .content("I'm post mapping");
        this.mockMvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.content().string("I'm post mapping"
                ));
    }


    @Test
    void indexPut() throws Exception{
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .put("/second")
                ;
        this.mockMvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.content().string("I'm put mapping"
                ));
    }


    @Test
    void indexPatch() throws Exception{
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post("/second")
                .content("I'm patch mapping");
        this.mockMvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.content().string("I'm post mapping"
                ));
    }


    @Test
    void indexDelete() throws Exception{
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post("/second")
                .content("I'm delete mapping");
        this.mockMvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.content().string("I'm post mapping"
                ));
    }

    @Test
    void indexApi() throws Exception{
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get("/api/range?from=1&to=5")
                .content("all params");
        this.mockMvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.content().string("1"+"\n"+
                        "2"+"\n"+
                        "3"+"\n"+
                        "4"+"\n"
                ));
    }


    @Test
    void indexApiSecond() throws Exception{
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get("/api/range/1/5")
                .content("all params");
        this.mockMvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.content().string("1"+"\n"+
                        "2"+"\n"+
                        "3"+"\n"+
                        "4"+"\n"
                ));
    }




}