package com.example.userservice;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.userservice.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
}