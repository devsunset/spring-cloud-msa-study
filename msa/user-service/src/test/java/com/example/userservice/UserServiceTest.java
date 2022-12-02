package com.example.userservice;

public class UserServiceTest {

//    private UserService userService;
//
//    private final UserRepository userRepository = mock(UserRepository.class);
//    private final TeamServiceClient teamServiceClient = mock(TeamServiceClient.class);
//
//    @Autowired
//    private RestTemplate restTemplate;
//
//    @BeforeEach
//    void setUp() {
//        userService = new UserService(userRepository, restTemplate, teamServiceClient);
//
//        User user = User.builder()
//                .id(1L)
//                .username("name")
//                .build();
//
//        TeamResponseData responseData = TeamResponseData.builder()
//                .teamId(1L)
//                .name("team name")
//                .address("address")
//                .build();
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
//    }
}