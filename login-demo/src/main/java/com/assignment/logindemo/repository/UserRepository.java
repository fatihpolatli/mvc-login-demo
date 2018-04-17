package com.assignment.logindemo.repository;

import org.springframework.data.repository.CrudRepository;

import com.assignment.logindemo.entity.User;

import reactor.core.publisher.Mono;

public interface UserRepository extends CrudRepository<User, String> {

    Mono<User> findByUsername(String username);
    
}