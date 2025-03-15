package com.hoboss.restful_web_services.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// REST API
@RestController
public class HelloWorldController {
    // /hello-world
    @GetMapping(path = "/hello-world")
    public String helloWorld() {
        return "Hello World";
    }
}
