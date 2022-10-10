package com.blog.service;
import com.blog.model.Like;
import com.blog.model.Post;
import com.blog.model.User;
public interface LikeService  {
    int countLike(int post_id);
    int deleteLike(long post_id , long user_id);
     public Like save(Like like);
    Like findLikeByPostAndAndUser(Post post , User user);
}
