package com.example.userservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.userservice.domain.dto.TeamResponseData;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
@RefreshScope
@EnableFeignClients
public class UserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }
    
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
    
 // FeignClient 어노테이션을 이용하면 직접 해당 URL을 명시하지 않더라도 Eureka 에 register한 Instance 이름을 찾아서 URL을 매핑
    @FeignClient(name = "team-service")
    public interface TeamServiceClient {
        @GetMapping("/team/{userId}/teams")
        TeamResponseData getTeam(@PathVariable("userId") Long id);
    }
    
    @Bean
    public FeignErrorDecoder getFeignErrorDecoder(){
       return new FeignErrorDecoder();
    }
    
    /////////////////////////////////////////////////////////////////

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
    public String gitconfig(@Value("${default.content}") String content,
                           @Value("${token.key}") String tokenKey,
                           @Value("${default.global-message}") String globalmessage,
                           @Value("${default.message}") String message) {
        return  "content: " + content + "<p/>"
                + "token key: " + tokenKey + "<p/>"
                + "global message: " + globalmessage + "<p/>"
                + "message: " + message;
    }
    
}
