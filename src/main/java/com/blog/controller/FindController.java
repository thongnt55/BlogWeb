package com.blog.controller;


import com.blog.model.Post;
import com.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

@Controller

public class FindController {
    private final PostService postService;

    @Autowired
    public FindController(PostService postService) {
        this.postService = postService;
    }


    @RequestMapping(value = "/home/find/{name}", method = RequestMethod.GET)
    public String getResult(@PathVariable String name) {
        Optional<Post> postServiceByBody;
        postServiceByBody = postService.findByBody(name);

        Optional<Post> postServiceByTitle;
        postServiceByTitle = postService.findByTitle(name);

        Optional<Post> postServiceByDescription;
        postServiceByDescription = postService.findByDescription(name);
        return "/";
    }
}
