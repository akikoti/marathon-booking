package com.kikoti.marathonbooking.Dtos;

import com.kikoti.marathonbooking.enams.UserRole;
import lombok.Data;

@Data
public class AuthenticationResponse {

    private String jwt;

    private UserRole userRole;

    private Long userId;

}
