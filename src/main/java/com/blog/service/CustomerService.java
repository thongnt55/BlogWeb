package com.blog.service;

import com.blog.model.User;

import java.util.Optional;

public interface CustomerService {
    Optional<User> findByEmail(String email);


    User createNewAfterOAuthLoginSuccess(String email, String name);

    User updateCustomerOAuth2(User user1, String name);

    User findByMail(String email);
}
