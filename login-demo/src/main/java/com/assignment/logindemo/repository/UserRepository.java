package com.assignment.logindemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment.logindemo.entity.User;

import reactor.core.publisher.Mono;

public interface UserRepository extends JpaRepository<User, String> {

    Mono<User> findByUsername(String username);
    
}