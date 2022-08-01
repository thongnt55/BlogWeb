package com.reljicd.service;

import com.reljicd.model.User;

import java.util.Optional;

public interface CustomerService {
    Optional<User> findByEmail(String email);


    User createNewAfterOAuthLoginSuccess(String email, String name);
}