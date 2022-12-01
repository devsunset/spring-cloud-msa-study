package com.example.teamservice.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamMemberRepository extends JpaRepository<TeamMember, Long> {
    TeamMember findByUserId(Long userId);
}