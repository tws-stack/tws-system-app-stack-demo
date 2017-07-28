package school.thoughtworks.system.app.demo.service.core.service;

import org.springframework.stereotype.Service;

@Service
public class HelloWorldService {

    public String say() {
        return "Hello World!";
    }
}
