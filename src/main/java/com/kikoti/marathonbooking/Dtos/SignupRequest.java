package com.kikoti.marathonbooking.Dtos;

import com.kikoti.marathonbooking.enams.Gender;
import lombok.Data;

@Data
public class SignupRequest {

    private String email;

    private String name;

    private String gender;

    private String phoneNumber;

    private String password;

}