package com.blog.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.blog.model.Like;
import com.blog.model.Post;
import com.blog.model.User;
import com.blog.service.LikeService;
import com.blog.service.PostService;
import com.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public @ResponseBody String Likenew(@PathVariable Long id, Authentication authentication, Model model) {
        ObjectMapper mapper = new ObjectMapper();
        String ajaxResponse = "";
        System.out.println(id + authentication.getName());
        Optional<Post> post = postService.findForId(id);
        Optional<User> user = userService.findByUsername(authentication.getName());
        System.out.println(user);
        try {
            if (user.isPresent()) {
                Like like = new Like();
                like.setUser(user.get());
                like.setPost(post.get());
                if (likeService.findLikeByPostAndAndUser(post.get(), user.get()) != null) {
                    System.out.println("exist");
                    likeService.deleteLike(post.get().getId(), user.get().getId());
                }
                else likeService.save(like);
                System.out.println(like);
                int countLike = likeService.countLike(Math.toIntExact(post.get().getId()));
                ajaxResponse = mapper.writeValueAsString(countLike);
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return ajaxResponse;
//        if (post.isPresent()) {
//            Optional<User> user = userService.findByUsername(authentication.getName());
//            if (user.isPresent()) {
//                Like like = new Like();
//                like.setUser(user.get());
//                like.setPost(post.get());
//                if( likeService.findLikeByPostAndAndUser(post.get() , user.get()) != null) {
//                    System.out.println("exist");
//                    likeService.deleteLike( post.get().getId(), user.get().getId());
//                }
//                else
//                    likeService.save(like);
//               return "redirect:/post/"+ like.getPost().getId();
//
//            } else {
//                return "/error";
//            }
//
//        } else {
//            return "/error";
//        }
    }
}
