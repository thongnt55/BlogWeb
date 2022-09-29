package com.blog.controller;

import com.blog.service.UserService;
import com.blog.util.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import net.bytebuddy.utility.RandomString;
import javax.servlet.http.HttpServletRequest;

@Controller
public class ForgotPasswordController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/forgot_password", method = RequestMethod.GET)
    public String forgotInfor(Model model){
        System.out.println("den d");
        model.addAttribute("pageTitle","Forgot_Password");
        return "/forgot_password_form";
    }
    @RequestMapping(value = "/forgot_password", method = RequestMethod.POST)
    public String processForgotPasswordForm(HttpServletRequest request){
        String email=request.getParameter("email");
        String token=RandomString.make(100);
        System.out.println("Email: "+email);
        System.out.println("Token: "+token);
        userService.updateResetPasswordToken(token,email);
        String resetLink= Utility.getSiteURL(request)+"/reset_password?token="+token;
        System.out.println(resetLink);
        return "/forgot_password_form";
    }
}
