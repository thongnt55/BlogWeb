package com.reljicd.repository;

import com.reljicd.model.Like;
import com.reljicd.model.Post;
import com.reljicd.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.transaction.annotation.Transactional;

public interface LikeRepository extends JpaRepository<Like, Long> {
    @Query(value = "select count( *) from LIKEE where POST_ID = ?", nativeQuery = true)
    int countLike( int post_id);
    @Modifying
    @Transactional
    @Query(value = "delete  from LIKEE where POST_ID = ?1 and USER_ID = ?2", nativeQuery = true)
    int deleteLike(long post_id , long user_id);


    Like findLikeByPostAndAndUser(Post post, User user);
}
