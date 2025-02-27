package com.kikoti.marathonbooking.services.auth;

import com.kikoti.marathonbooking.Dtos.SignupRequest;
import com.kikoti.marathonbooking.Dtos.UserDto;

public interface AuthService {

    UserDto createCustomer(SignupRequest signupRequest);

    boolean hasCustomerWithEmail(String email);

}