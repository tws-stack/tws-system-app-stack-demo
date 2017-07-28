package school.thoughtworks.system.app.demo.service.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import school.thoughtworks.system.app.demo.service.core.service.HelloWorldService;

@RestController
@RequestMapping(value = "/hello")
public class HelloWorldController {

    private HelloWorldService helloWorldService;

    @Autowired
    public HelloWorldController(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String hello() {
        return helloWorldService.say();
    }
}
