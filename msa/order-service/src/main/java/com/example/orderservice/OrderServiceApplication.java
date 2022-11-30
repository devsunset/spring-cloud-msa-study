package com.example.orderservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class OrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }

    @GetMapping("/order/info")
    public String info(@Value("${server.port}") String port) {
        return "Order 서비스의 기본 동작 Port: {" + port + "}";
    }

//    # local-msa-config 테스트시 주석 해제 
//    @GetMapping("/info") - yaml 설정 RewritePath=/order/?(?<segment>.*), /$\{segment} # /order/ 경로를 없앰
//    public String info(@Value("${server.port}") String port) {
//        return "Order 서비스의 기본 동작 Port: {" + port + "}";
//    }
    
//    @GetMapping("/order/config")
//    public String string(@Value("${message.owner}") String messageOwner,
//                         @Value("${message.content}") String messageContent) {
//        return "Configuration File's Message Owner: " + messageOwner + "\n"
//                + "Configuration File's Message Content: " + messageContent;
//    }

}