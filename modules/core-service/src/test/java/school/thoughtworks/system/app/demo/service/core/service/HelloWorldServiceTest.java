package school.thoughtworks.system.app.demo.service.core.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class HelloWorldServiceTest {

    @Test
    public void say_should_return_hello_world() throws Exception {

        HelloWorldService helloWorldService = new HelloWorldService();

        String result = helloWorldService.say();

        assertThat(result).isEqualTo("Hello World!");
    }
}
