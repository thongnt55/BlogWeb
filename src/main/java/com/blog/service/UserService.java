package com.blog.service;

import com.blog.model.User;

import java.util.Optional;

public interface UserService {

    Optional<User> findByUsername(String username);

    Optional<User> findByName(String username);

    Optional<User> findByEmail(String email);

    User save(User user);
    int updateUser(Long id, String name , String lastname ,String email);

    User findByMail(String email);
    void updateResetPasswordToken(String token, String email);
    User get(String resetPasswordToken);
    void updatePassword(User user, String newPassword);
}
