package com.reljicd.config;

import com.reljicd.model.User;
import com.reljicd.service.CustomerService;
import com.reljicd.service.impl.CustomerOAuth2UserImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.AttributedString;
import java.util.Optional;

@Component
public class OAuth2LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    @Autowired
    private CustomerService customerService;
    private Model model;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws ServletException, IOException {

        CustomerOAuth2UserImp customerOAuth2UserImp=(CustomerOAuth2UserImp)authentication.getPrincipal();

        System.out.println(authentication.getName());

        String clientName = customerOAuth2UserImp.getClientName();
        String email = customerOAuth2UserImp.getEmail();
        String name = customerOAuth2UserImp.getName();

//        System.out.println("client name"+clientName);
        System.out.println("OAuth2 email"+customerOAuth2UserImp.getEmail());

        User user = customerService.findByMail(email);
        System.out.println(user);
        if(user == null){
            System.out.println("New user");
            customerService.createNewAfterOAuthLoginSuccess(email,name);

        }else {
            System.out.println("Existing user in db, update user");
            customerService.updateCustomerOAuth2(user,name);
        }
        response.sendRedirect("/home");

    }
}
