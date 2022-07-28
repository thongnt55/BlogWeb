package com.reljicd.controller;

import com.reljicd.common.GooglePojo;
import org.apache.http.client.ClientProtocolException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.reljicd.common.GoogleUtils;
import org.springframework.beans.factory.annotation.Autowired;


import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.security.Principal;

@Controller
public class LoginController {
    @Autowired
	private GoogleUtils googleUtils;

    @GetMapping("/login")
    public String login(Principal principal) {

        if (principal != null) {
        	System.out.println(principal.getName());
        	System.err.println(principal);
            return "redirect:/home";
        }
        return "/login";
    }
    @RequestMapping("/login-google")
    public String loginGoogle(HttpServletRequest request) throws ClientProtocolException, IOException {
        System.out.println("da chay toi day");
        String code = request.getParameter("code");

        if (code == null || code.isEmpty()) {
            return "redirect:/login?google=error";
        }

        String accessToken = googleUtils.getToken(code);

        GooglePojo googlePojo = googleUtils.getUserInfo(accessToken);
        UserDetails userDetail = googleUtils.buildUser(googlePojo);
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetail, null,
                userDetail.getAuthorities());
        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return "redirect:/home";
    }

}
