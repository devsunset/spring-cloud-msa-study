package com.example.userservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
@RefreshScope
public class UserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

    @GetMapping("/user/info")
    public String info(@Value("${server.port}") String port) {
        return "User  서비스의 기본 동작 Port: {" + port + "}";
    }
    
//  @GetMapping("/info") -  yaml 설정 RewritePath=/user/?(?<segment>.*), /$\{segment}  # /user/ 경로를 없앰
//  public String info(@Value("${server.port}") String port) {
//      return "User 서비스의 기본 동작 Port: {" + port + "}";
//  }

    
//    # local-msa-config 테스트시 주석 해제 
//    @GetMapping("/user/config")
//    public String string(@Value("${message.owner}") String messageOwner,
//                         @Value("${message.content}") String messageContent) {
//        return "Configuration File's Message Owner: " + messageOwner + "\n"
//                + "Configuration File's Message Content: " + messageContent;
//    }
    
    @GetMapping("/user/config/git")
    public String gitconfig(@Value("${spring.datasource.driver}") String driver,
                           @Value("${spring.datasource.url}") String url,
                           @Value("${spring.datasource.username}") String username,
                           @Value("${spring.datasource.password}") String password,
                           @Value("${token.key}") String tokenKey,
                           @Value("${default.content}") String content,
                           @Value("${default.message}") String message) {
        return "driver: " + driver + "<p/>"
                + "url: " + url + "<p/>"
                + "username: " + username + "<p/>"
                + "password: " + password + "<p/>"
                + "token key: " + tokenKey + "<p/>"
                + "content: " + content + "<p/>"
                + "message: " + message;
    }
    
}
