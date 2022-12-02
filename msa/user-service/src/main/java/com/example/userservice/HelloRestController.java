package com.example.userservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {

    private final HelloService helloService;

    public HelloRestController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/user/hello")
    public String hello() {
        return helloService.greeting();
    }
}
