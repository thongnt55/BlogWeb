package com.reljicd.config;

import com.reljicd.model.User;
import com.reljicd.service.CustomerService;
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
    private CustomerService customerService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        CustomerOAuth2UserImp customerOAuth2UserImp=(CustomerOAuth2UserImp) authentication.getPrincipal();

        //customerOAuth2UserImp.getName();
        String clientName = customerOAuth2UserImp.getClientName();

        String email = customerOAuth2UserImp.getEmail();
        String name = customerOAuth2UserImp.getName();

        System.out.println("client name"+clientName);
        System.out.println("OAuth2 email"+customerOAuth2UserImp.getEmail());

        Optional<User> user = customerService.findByEmail(email);
        System.out.print(user);
        String u =user.toString();
        System.out.print(u);
        if(u == "Optional.empty"){
            System.out.println("New user");
            customerService.createNewAfterOAuthLoginSuccess(email,name);
        }else {
            System.out.println("update existing user");
        }
    }
}
