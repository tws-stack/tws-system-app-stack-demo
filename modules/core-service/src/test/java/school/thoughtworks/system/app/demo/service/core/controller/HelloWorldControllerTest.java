package school.thoughtworks.system.app.demo.service.core.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import school.thoughtworks.system.app.demo.service.core.service.HelloWorldService;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
@WebMvcTest(HelloWorldController.class)
public class HelloWorldControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private HelloWorldService helloWorldService;

    @Test
    public void should_return_hello_world() throws Exception {

        when(helloWorldService.say()).thenReturn("Hello World!");

        mvc.perform(get("/hello"))
                .andExpect(content().string("Hello World!"));
    }
}