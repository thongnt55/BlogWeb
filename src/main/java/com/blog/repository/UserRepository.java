package com.blog.repository;

import com.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(@Param("email") String email);

    Optional<User> findByUsername(@Param("username") String username);


    Optional<User> findByName(@Param("name") String name);

    @Modifying
    @Transactional
    @Query(value ="update user  u set u.name=:name , u.LAST_NAME=:lastname , u.email=:email where u.USER_ID =:id ",nativeQuery = true )
    int updateUser(@Param("name")String name, @Param("lastname")String lastname , @Param("email") String email,@Param("id") Long id);

}
