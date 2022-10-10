package com.blog.controller;

import com.blog.model.Comment;
import com.blog.model.Post;
import com.blog.model.User;
import com.blog.service.CommentService;
import com.blog.service.PostService;
import com.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class CommentController {

    private final PostService postService;
    private final UserService userService;
    private final CommentService commentService;

    @Autowired
    public CommentController(PostService postService, UserService userService, CommentService commentService) {
        this.postService = postService;
        this.userService = userService;
        this.commentService = commentService;
    }

    @RequestMapping(value = "/createComment", method = RequestMethod.POST)
    public String createNewPost(@Valid Comment comment,
                                BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "/comment/commentForm";

        } else {
            commentService.save(comment);
            return "redirect:/post/" + comment.getPost().getId();
        }
    }

    @RequestMapping(value = "/commentPost/{id}", method = RequestMethod.GET)
    public String commentPostWithId(@PathVariable Long id, Authentication authentication,
                                    Model model) {

        Optional<Post> post = postService.findForId(id);

        if (post.isPresent()) {
            Optional<User> user = userService.findByUsername(authentication.getName());

            if (user.isPresent()) {
                Comment comment = new Comment();
                comment.setUser(user.get());
                comment.setPost(post.get());

                model.addAttribute("comment", comment);

                return "/comment/commentForm";

            } else {
                return "/error/error";
            }

        } else {
            return "/error/error";
        }
    }

}
