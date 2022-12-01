package com.example.userservice;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.example.userservice.UserServiceApplication.TeamServiceClient;
import com.example.userservice.domain.User;
import com.example.userservice.domain.UserRepository;
import com.example.userservice.domain.dto.TeamResponseData;
import com.example.userservice.domain.dto.UserResponseData;

public class UserServiceTest {

    private UserService userService;

    private final UserRepository userRepository = mock(UserRepository.class);
    private final TeamServiceClient teamServiceClient = mock(TeamServiceClient.class);

    @Autowired
    private RestTemplate restTemplate;

    @BeforeEach
    void setUp() {
        userService = new UserService(userRepository, restTemplate, teamServiceClient);

        User user = User.builder()
                .id(1L)
                .username("name")
                .build();

        TeamResponseData responseData = TeamResponseData.builder()
                .teamId(1L)
                .name("team name")
                .address("address")
                .build();
        
        /*
        given(userRepository.findById(anyLong())).willReturn(Optional.of(user));

        // Feign Test
        given(teamServiceClient.getTeam(anyLong())).willReturn(responseData);


        // RestTemplate Test
        given(restTemplate.exchange(eq("http://localhost:8000/team/1L/teams"),
                HttpMethod.GET, null, UserResponseData.class))
                .will(invocation ->
                    ResponseEntity.status(HttpStatus.OK).body(responseData)
                );
        */
    }
}