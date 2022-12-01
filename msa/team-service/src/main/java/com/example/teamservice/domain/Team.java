package com.example.teamservice.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "team")
@Getter
@Setter
@Builder
public class Team {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String address;

	public Team() {

	}

	public Team(Long id, String name, String address) {
		this.id = id;
		this.name = name;
		this.address = address;

	}
}