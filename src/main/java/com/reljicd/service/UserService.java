package com.reljicd.service;

import com.reljicd.model.User;

import java.util.Optional;

public interface UserService {

    Optional<User> findByUsername(String username);

    Optional<User> findByName(String username);

    Optional<User> findByEmail(String email);

    User save(User user);

    User update(User user);
}
