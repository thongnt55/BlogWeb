package com.blog.service.impl;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.Map;

public class CustomerOAuth2UserImp implements OAuth2User {
	private String clientName;
	private OAuth2User oauth2User;


	public CustomerOAuth2UserImp(OAuth2User oauth2User, String clientName) {
		this.oauth2User = oauth2User;
		this.clientName=clientName;
	}

	@Override
	public Map<String, Object> getAttributes() {
		// TODO Auto-generated method stub
		return oauth2User.getAttributes();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return oauth2User.getAuthorities();
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return oauth2User.getAttribute("name");
	}
	public String getEmail(){
		return oauth2User.getAttribute("email");
	}
	public String getClientName(){
		return this.clientName;
	}

}
