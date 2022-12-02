package com.example.teamservice;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class HelloService {

    @CircuitBreaker(name = "hello", fallbackMethod = "helloFallback")
    public String greeting() {
        randomException();
        return "hello world!";
    }

    private void randomException() {
        int randomInt = new Random().nextInt(10);

        if(randomInt <= 7) {
            throw new RuntimeException("failed");
        }
    }

    @SuppressWarnings("unused")
	private String helloFallback(Throwable t) {
        return "fallback invoked! exception type : " + t.getClass();
    }

}
