package com.kikoti.marathonbooking.Dtos;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class MarathonDto {
    private Long id;
    private String name;
    private String location;
    private LocalDate date;
    private LocalTime time;
    private String description;
    private int maxParticipants;
    private boolean isActive;
    private double registrationFee;
}

