package com.example.ExpenseTrackerApp.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.ExpenseTrackerApp.entity.Userr;
import com.example.ExpenseTrackerApp.repository.UserRepository;

@Service
public class LoginService implements UserDetailsService {

    private final UserRepository customerRepository;

    @Autowired
    public LoginService(UserRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Write logic to fetch customer from DB
        Userr customer = customerRepository.findByUsername(username);
//                .orElseThrow(() -> new UsernameNotFoundException("Customer not found with email: " + username));

        return new User(customer.getUsername(), customer.getPassword(), Collections.emptyList());
    }
}