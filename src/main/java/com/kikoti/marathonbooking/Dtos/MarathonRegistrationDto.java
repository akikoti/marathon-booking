package com.kikoti.marathonbooking.Dtos;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MarathonRegistrationDto {
    //private Long id;
    @NotNull(message = "User ID is required")
    private Long userId;

    @NotNull(message = "Marathon ID is required")
    private Long marathonId;
    private LocalDateTime registrationDate;
}
