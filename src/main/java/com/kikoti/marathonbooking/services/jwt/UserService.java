package com.kikoti.marathonbooking.services.jwt;


import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {

    UserDetailsService userDetailsService();

}