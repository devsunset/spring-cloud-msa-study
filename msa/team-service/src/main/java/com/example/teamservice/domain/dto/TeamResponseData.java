package com.example.teamservice.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class TeamResponseData {
	private Long teamId;
	private String name;
	private String address;
}