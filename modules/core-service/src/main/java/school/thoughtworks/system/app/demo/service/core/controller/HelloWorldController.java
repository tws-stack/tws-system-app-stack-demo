package school.thoughtworks.system.app.demo.service.core.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/hello")
public class HelloWorldController {

    @RequestMapping(method = RequestMethod.GET)
    public String hello() {
        return "Hello World!";
    }
}
