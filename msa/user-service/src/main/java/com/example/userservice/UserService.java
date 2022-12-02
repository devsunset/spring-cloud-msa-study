package com.example.userservice;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.example.userservice.UserServiceApplication.TeamServiceClient;
import com.example.userservice.domain.User;
import com.example.userservice.domain.UserRepository;
import com.example.userservice.domain.dto.TeamResponseData;
import com.example.userservice.domain.dto.UserCreateData;
import com.example.userservice.domain.dto.UserResponseData;

import lombok.extern.slf4j.Slf4j;


@Service
@Transactional
@Slf4j
public class UserService {

    private final UserRepository userRepository;
    private final RestTemplate restTemplate;
    private final TeamServiceClient teamServiceClient;


    public UserService(UserRepository userRepository, RestTemplate restTemplate, TeamServiceClient teamServiceClient) {
        this.userRepository = userRepository;
        this.restTemplate = restTemplate;
        this.teamServiceClient = teamServiceClient;
    }

    /**
     * 사용자를 저장한다
     *
     * @param userCreateData 저장하려는 사용자 이름
     * @return 저장된 사용자
     */
    public UserResponseData save(UserCreateData userCreateData) {
    	
    	log.info("UserService save");

        User user = User.builder()
                .username(userCreateData.getUsername())
                .build();

        user = userRepository.save(user);

        // Rest Template or Feign Client 작업 처리

        return  UserResponseData.builder()
                .userId(user.getId()) 
                .username(user.getUsername())
                .team(null) // Rest Template or Feign Client
                .build();
    }
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    
//  Rest Template vs.  Fegin 
//  이름 				코드 가독성, 직관성 					예외 처리 			테스트 용이성 								러닝 커브
//  Rest Template 		가독성이 좋게 하기 위한 추가 작업 필요    try-catch 			Spring 이 구현해놓은 객체의 복잡한 stubbing 	낮음
//  Open Feign 			가독성 좋음  							ErrorDecoder 제공 	일반적인 인터페이스의 간편한 stubbing 		낮음
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * 사용자를 조회한다.
     *
     * @param id 사용자 id
     * @return 저장된 사용자와 팀 정보
     * @throws RuntimeException
     */
    public UserResponseData getUserById(Long id) {
        User userOptional = userRepository.findById(id)
                .orElseThrow(RuntimeException::new);

        // Rest Template or Feign Client 작업 처리

        return UserResponseData.builder()
                .userId(userOptional.getId())
                .username(userOptional.getUsername())
                .team(null)
                .build();
    }
    
    /**
     * 사용자를 조회한다.
     *
     * @param id 사용자 id
     * @return 저장된 사용자와 팀 정보
     */
    public UserResponseData getUserByIdRestTemplate(Long id) {
	    User userOptional = userRepository.findById(id)
	            .orElseThrow(RuntimeException::new);
	
	     TeamResponseData team = null;
	    // Team team = GET team-service/team/{userId}/teams 
	    // RestTemplate 를 bean 으로 주입할 때, @LoadBalanced 어노테이션을 추가하였기 때문에 직접적인 team-service의 주소 체계를 이용하지 않고 Microservice의 이름 체계를 이용
	    String url = String.format("http://team-service/team/%s/teams", id);
	    
	    try {
	
	      ResponseEntity<TeamResponseData> responseData = restTemplate.exchange(url,
	            HttpMethod.GET,
	            null,
	            TeamResponseData.class);
	
	      team = responseData.getBody();
	
	    }catch (Exception e) {
	    	throw e;
	    }
	    return UserResponseData.builder()
	            .userId(userOptional.getId())
	            .username(userOptional.getUsername())
	            .team(team) // Team-Service 로 조회한 Team 정보를 담아서 반환
	            .build();
	}
    
    /**
     * 사용자를 조회한다.
     *
     * @param id 사용자 id
     * @return 저장된 사용자와 팀 정보
     */
    public UserResponseData getUserByIdFegin(Long id) {
        User userOptional = userRepository.findById(id)
                .orElseThrow(RuntimeException::new);

        TeamResponseData team = teamServiceClient.getTeam(id);

        return UserResponseData.builder()
                .userId(userOptional.getId())
                .username(userOptional.getUsername())
                .team(team) // Team-Service 로 조회한 Team 정보를 담아서 반환
                .build();
    }
    
}