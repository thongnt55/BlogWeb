package com.reljicd.config;

import com.reljicd.model.User;
import com.reljicd.service.UserService;
import com.reljicd.service.impl.CustomerOAuth2UserImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@Component
public class OAuth2LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    @Autowired
    private UserService userService;
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        CustomerOAuth2UserImp customerOAuth2UserImp=(CustomerOAuth2UserImp) authentication.getPrincipal();
        System.out.println("OAuth2 username"+customerOAuth2UserImp.getName());
        System.out.println("OAuth2 email"+customerOAuth2UserImp.getEmail());
        //customerOAuth2UserImp.getName();
        String email = customerOAuth2UserImp.getEmail();

        Optional<User> user = userService.findByEmail(email);

        if(user !=null){
            System.out.println("User alredy exist in db");
        }else {
            System.out.println("New user");
        }
    }
}
