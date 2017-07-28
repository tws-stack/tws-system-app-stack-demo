package school.thoughtworks.system.app.demo.service.core.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import school.thoughtworks.system.app.demo.service.core.service.HelloWorldService;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
public class HelloWorldControllerTest {

    private MockMvc mockMvc;

    @Mock
    private HelloWorldService helloWorldService;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(new HelloWorldController(helloWorldService)).build();
    }

    @Test
    public void should_return_hello_world() throws Exception {

        when(helloWorldService.say()).thenReturn("Hello World!");

        RequestBuilder request = get("/hello");
        mockMvc.perform(request)
                .andExpect(content().string("Hello World!"));
    }
}