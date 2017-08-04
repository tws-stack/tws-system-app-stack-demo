package school.thoughtworks.system.app.demo.service.core.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class HelloWorldServiceTest {

    private HelloWorldService helloWorldService;

    @Before
    public void setUp() throws Exception {
        helloWorldService = new HelloWorldService();
    }

    @Test
    public void say_should_return_hello_world() throws Exception {
        String result = helloWorldService.say();
        assertThat(result).isEqualTo("Hello World!");
    }

}

