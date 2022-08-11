package com.reljicd.controller;

import com.reljicd.model.Category;
import com.reljicd.model.Post;
import com.reljicd.model.User;
import com.reljicd.repository.CategoryRepository;
import com.reljicd.service.LikeService;
import com.reljicd.service.PostService;
import com.reljicd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class PostController {

    private final PostService postService;
    private final UserService userService;
    private final CategoryRepository categoryRepository;
    private final LikeService likeservice;
    @Autowired
    public PostController(PostService postService, UserService userService, CategoryRepository categoryRepository, LikeService likeservice) {
        this.postService = postService;
        this.userService = userService;
        this.categoryRepository = categoryRepository;
        this.likeservice = likeservice;
    }

    @RequestMapping(value = "/newPost", method = RequestMethod.GET)
    public String newPost(Authentication authentication,
                          Model model) {
        List<Category> categories = categoryRepository.findAll();
        //System.out.println("categories: "+categories);
        model.addAttribute("categories",categories);
        Optional<User> user = userService.findByUsername(authentication.getName());

        if (user.isPresent()) {
            Post post = new Post();
            post.setUser(user.get());

            model.addAttribute("post", post);


            return "/post/postForm";

        } else {
            return "/error/error";
        }
    }

    @RequestMapping(value = "/newPost", method = RequestMethod.POST)
    public String createNewPost(@Valid Post post, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "/post/postForm";
        } else {
            postService.save(post);
            return "redirect:/blog/" + post.getUser().getUsername();
        }
    }

    @RequestMapping(value = "/editPost/{id}", method = RequestMethod.GET)
    public String editPostWithId(@PathVariable Long id,
                                 Authentication authentication,
                                 Model model) {
        List<Category> categories = categoryRepository.findAll();
        //System.out.println("categories: "+categories);
        model.addAttribute("categories",categories);
        Optional<Post> optionalPost = postService.findForId(id);

        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();

            if (isAuthenticationOwnerOfPost(authentication, post)) {
                model.addAttribute("post", post);
                return "/post/postForm";
            } else {
                return "/error/403";
            }

        } else {
            return "/error/error";
        }
    }

    @RequestMapping(value = "/post/{id}", method = RequestMethod.GET)
    public String getPostWithId(@PathVariable Long id,
                                Authentication authentication,
                                Model model) {
// count like cho bai biet nay
        Optional<Post> optionalPost = postService.findForId(id);

        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();

            model.addAttribute("post", post);
            model.addAttribute("countLike", likeservice.countLike(Math.toIntExact(post.getId())));
            if (isAuthenticationOwnerOfPost(authentication, post)) {
                model.addAttribute("username", authentication.getName());
            }
            System.out.println( likeservice.countLike(Math.toIntExact(post.getId())));
            return "/post/post";

        } else {
            return "/error/error";
        }
    }

    @RequestMapping(value = "/post/{id}", method = RequestMethod.POST)
    public String deletePostWithId(@PathVariable Long id,
                                   Authentication authentication) {

        Optional<Post> optionalPost = postService.findForId(id);

        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();

            if (isAuthenticationOwnerOfPost(authentication, post)) {
                postService.delete(post);
                return "redirect:/home";
            } else {
                return "/error/403";
            }

        } else {
            return "/error/error";
        }
    }

    private boolean isAuthenticationOwnerOfPost(Authentication authentication, Post post) {
        return authentication != null && authentication.getName().equals(post.getUser().getUsername());
    }
}
