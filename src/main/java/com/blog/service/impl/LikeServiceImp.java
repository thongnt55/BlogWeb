package com.blog.service.impl;

import com.blog.model.Like;
import com.blog.model.Post;
import com.blog.model.User;
import com.blog.repository.LikeRepository;
import com.blog.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeServiceImp implements LikeService {
    private final LikeRepository likerepo;

    @Autowired
    public LikeServiceImp(LikeRepository likerepo) {
        this.likerepo = likerepo;
    }

    @Override
    public int countLike(int post_id){

        return likerepo.countLike(post_id);
    }

    @Override
    public int deleteLike(long post_id , long user_id) {

        return likerepo.deleteLike(post_id , user_id);
    }

    @Override
    public Like save(Like like) {
        return likerepo.saveAndFlush(like);
    }


    @Override
    public Like findLikeByPostAndAndUser(Post post , User user){
        return likerepo.findLikeByPostAndAndUser(post , user);
    }
}
