package com.example.orderservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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



@RefreshScope
@RestController
class ApiCallRestController {
	

	@Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
    
    @FeignClient(name = "user")
    public interface UserServiceClient {
        @GetMapping("/{userId}/teams")
        String getStaticuser();
    }
    
//    이름 				코드 가독성, 직관성 					예외 처리 			테스트 용이성 								러닝 커브
//    Open Feign 		가독성 좋음  							ErrorDecoder 제공 	일반적인 인터페이스의 간편한 stubbing 		낮음
//    Rest Template 	가독성이 좋게 되기 위해 다른 작업 필요 	try-catch 			Spring 이 구현해놓은 객체의 복잡한 stubbing 	낮음
    
    @GetMapping("/order/apicall/resttemplate")
    public String apiCallbyRestTemplate() {
        String url = "http://user-service/user/staticuser";

        ResponseEntity<String> responseData = this.restTemplate().exchange(url,
                HttpMethod.GET,
                null,
                String.class);

        String userInfo = responseData.getBody();
        	   userInfo = userInfo+" , api : RestTemplate";

        return "aaa"; 
    }
    
    
    @GetMapping("/order/apicall/fegin")
    public String apiCallbyFegin() {
//    	 String userInfo = this.UserServiceClient.getStaticuser();
        return "username: fegin , password:1234"; 
    }
}