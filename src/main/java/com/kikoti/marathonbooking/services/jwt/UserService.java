package com.kikoti.marathonbooking.services.jwt;


import com.kikoti.marathonbooking.entities.Users;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {

    UserDetailsService userDetailsService();

    Users findFirstByEmail(String username);
}