package com.reljicd.service;
import com.reljicd.model.Like;
import com.reljicd.model.Post;
import com.reljicd.model.User;
public interface LikeService  {
    int countLike(int post_id);
    int deleteLike(long post_id , long user_id);
     public Like save(Like like);
    Like findLikeByPostAndAndUser(Post post , User user);
}
