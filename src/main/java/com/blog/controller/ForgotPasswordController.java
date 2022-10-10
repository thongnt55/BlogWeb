package com.blog.controller;

import com.blog.model.User;
import com.blog.service.UserService;
import com.blog.util.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import net.bytebuddy.utility.RandomString;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

@Controller
public class ForgotPasswordController {
    @Autowired
    private UserService userService;
    @Autowired
    private JavaMailSender mailSender;
    @RequestMapping(value = "/forgot_password", method = RequestMethod.GET)
    public String forgotInfor(Model model){
        System.out.println("den d");
        model.addAttribute("pageTitle","Forgot_Password");
        return "/forgot_password_form";
    }
    @RequestMapping(value = "/forgot_password", method = RequestMethod.POST)
    public String processForgotPasswordForm(HttpServletRequest request,Model model){
        String email=request.getParameter("email");
        String token=RandomString.make(100);
        System.out.println("Email: "+email);
        System.out.println("Token: "+token);
        userService.updateResetPasswordToken(token,email);
        String resetLink= Utility.getSiteURL(request)+"/reset_password?token="+token;
        System.out.println(resetLink);

        try {
            sendEmail(email,resetLink);
            model.addAttribute("message","I have sent reset password link to your email. Please check your inbox.");
        } catch (MessagingException e) {
            model.addAttribute("error",e.getMessage());
        } catch (UnsupportedEncodingException e) {
            model.addAttribute("error","ERROR when sending email.");
        }
        model.addAttribute("pageTitle","Forgot_Password");
        return "/forgot_password_form";
    }

    private void sendEmail(String email,  String resetLink) throws MessagingException, UnsupportedEncodingException {
        MimeMessage message= mailSender.createMimeMessage();
        MimeMessageHelper helper= new MimeMessageHelper(message);

        helper.setFrom("nguyentuanthongdacso@gmail.com","Blog support");
        helper.setTo(email);

        String subject="Here is link to reset your password";
        String content="<p>Hello,</p>"
                + "<p>You have requested to reset your password</p>"
                + "<p>Click the link below to change your password</p>"
                + "<a href=\"" + resetLink + "\">Change my password</a>"
                +"<p>Ignore this email if you do remember password, or you have not made the request.</p>";
        helper.setSubject(subject);
        helper.setText(content,true);
        mailSender.send(message);
    }
    @RequestMapping(value = "/reset_password", method = RequestMethod.GET)
    public String resetPasswordForm(@Param(value = "token") String token, Model model){

        User user=userService.get(token);
        if(user==null){
            model.addAttribute("title","Reset your password");
            model.addAttribute("message","Invalid token");
            return "/message";
        }
        model.addAttribute("token",token);
        model.addAttribute("pageTitle","Reset your password");
        return "/reset_password_form";
    }
    @RequestMapping(value = "/reset_password", method = RequestMethod.POST)
    public String resetPassword(HttpServletRequest request,Model model){
        String token = request.getParameter("token");
        String password= request.getParameter("password");
        User user=userService.get(token);
        if(user==null){
            model.addAttribute("title","Reset your password");
            model.addAttribute("message","Invalid token");
        }else {
            userService.updatePassword(user,password);
            model.addAttribute("message","Succesfully!");
        }

        return "/message";

    }

}
