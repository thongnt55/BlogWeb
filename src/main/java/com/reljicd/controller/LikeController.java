package com.reljicd.controller;

import com.reljicd.model.Comment;
import com.reljicd.model.Post;
import com.reljicd.model.User;
import com.reljicd.model.Like;
import com.reljicd.service.CommentService;
import com.reljicd.service.LikeService;
import com.reljicd.service.PostService;
import com.reljicd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.Optional;

@Controller

public class LikeController {
    private final PostService postService;
    private final UserService userService;
    private final LikeService likeService;
    @Autowired
    public LikeController(PostService postService, UserService userService, LikeService likeService) {
        this.postService = postService;
        this.userService = userService;
        this.likeService = likeService;
    }

    @RequestMapping(value = "/Like/{id}", method = RequestMethod.GET)
    public String Likenew(@PathVariable Long id,
                                    Principal principal,
                                    Model model) {

        Optional<Post> post = postService.findForId(id);

        if (post.isPresent()) {
            Optional<User> user = userService.findByUsername(principal.getName());
            if (user.isPresent()) {
                Like like = new Like();
                like.setUser(user.get());
                like.setPost(post.get());
                if( likeService.findLikeByPostAndAndUser(post.get() , user.get()) != null) {
                    System.out.println("exist");
                    likeService.deleteLike( post.get().getId(), user.get().getId());
                }
                else
                    likeService.save(like);
               return "redirect:/post/"+ like.getPost().getId();

            } else {
                return "/error";
            }

        } else {
            return "/error";
        }
    }
}
