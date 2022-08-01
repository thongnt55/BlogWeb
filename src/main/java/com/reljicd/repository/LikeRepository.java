package com.reljicd.repository;

import com.reljicd.model.Like;
import com.reljicd.model.Post;
import com.reljicd.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


public interface LikeRepository extends JpaRepository<Like, Long> {
    @Query(value = "select count( *) from LIKEE where POST_ID = ?", nativeQuery = true)
    int countLike( int post_id);


    @Modifying
    @Transactional
    @Query(value = "delete from LIKEE likee where likee.POST_ID=:post_id and likee.USER_ID=:user_id", nativeQuery = true)
    int deleteLike(@Param("post_id")long post_id ,@Param("user_id") long user_id);


    Like findLikeByPostAndAndUser(Post post, User user);
}
