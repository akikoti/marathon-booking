package com.kikoti.marathonbooking.Dtos;

import com.kikoti.marathonbooking.enams.UserRole;
import lombok.Data;

@Data
public class UserDto {

    private Long id;

    private String name;

    private String email;

    private String password;

    private UserRole userRole;

}
