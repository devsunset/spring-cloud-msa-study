package com.example.userservice.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class UserResponseData {
    private Long userId;
    private String username;
    private TeamResponseData team;
}