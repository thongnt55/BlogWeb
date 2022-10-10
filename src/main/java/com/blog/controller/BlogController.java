package com.blog.controller;

import com.blog.model.Post;
import com.blog.model.User;
import com.blog.service.PostService;
import com.blog.service.UserService;
import com.blog.util.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class BlogController {

    private final UserService userService;

    private final PostService postService;

    @Autowired
    public BlogController(UserService userService, PostService postService) {
        this.userService = userService;
        this.postService = postService;
    }

    @RequestMapping(value = "/blog/{username}", method = RequestMethod.GET)
    public String blogForUsername(@PathVariable String username,
                                  @RequestParam(defaultValue = "0") int page,
                                  Model model) {

        Optional<User> optionalUser = userService.findByUsername(username);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            Page<Post> posts = postService.findByUserOrderedByDatePageable(user, page);
            Pager pager = new Pager(posts);

            model.addAttribute("pager", pager);
            model.addAttribute("user", user);

            return "/post/posts";

        } else {
            return "/error/error";
        }
    }
//
//    @RequestMapping(value = "/blog/{category}", method = RequestMethod.GET)
//    public String blogForCategory(@PathVariable String category,
//                                  @RequestParam(defaultValue = "0") int page,
//                                  Model model) {
//
//
//            Page<Post> posts = postService.findForCategory(category, page);
//            Pager pager = new Pager(posts);
//
//            model.addAttribute("pager", pager);
//            model.addAttribute("category", category);
//
//            return "/posts";
//
//
//    }
}
