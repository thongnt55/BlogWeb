package com.reljicd.service.impl;

import com.reljicd.model.User;
import com.reljicd.repository.CustomerRepository;
import com.reljicd.repository.RoleRepository;
import com.reljicd.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class CustomerImp implements CustomerService {
    private final CustomerRepository customerRepository;
    private final RoleRepository roleRepository;
    private static final String USER_ROLE = "ROLE_USER";

    public CustomerImp(CustomerRepository customerRepository, RoleRepository roleRepository) {
        this.customerRepository = customerRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return customerRepository.findByEmail(email);
    }

    @Override
    public User createNewAfterOAuthLoginSuccess(String email, String name) {
        User user=new User();

        user.setActive(1);
        user.setEmail(email);
        user.setUsername(email);
        user.setPassword(email);
        user.setName(name);
        user.setRoles(Collections.singletonList(roleRepository.findByRole(USER_ROLE)));

        return customerRepository.saveAndFlush(user);
    }


}
