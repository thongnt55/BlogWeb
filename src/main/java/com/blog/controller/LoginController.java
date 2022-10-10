package com.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LoginController {
    @Autowired
    AuthenticationManager authenticationManager;
    @GetMapping("/login")
    public String login(Authentication authentication) {
        System.out.println("authentication:" + authentication);
        if (authentication != null) {
        	System.out.println(authentication.getName());
        	System.err.println(authentication);
            return "redirect:/home";
        }
        return "/login";
    }

}
