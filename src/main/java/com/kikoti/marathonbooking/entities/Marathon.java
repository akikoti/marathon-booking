package com.kikoti.marathonbooking.entities;

import com.kikoti.marathonbooking.Dtos.MarathonDto;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@Entity
@Table(name = "marathons")
public class Marathon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String location;
    private LocalDate date;
    private LocalTime time;
    private String description;
    private Integer maxParticipants;
    private boolean isActive;
    private double registrationFee;
    private Integer registeredParticipantsCount = 0;

    @Version
    private Long version;

    @CreationTimestamp
    private LocalDateTime dateCreated;

    @UpdateTimestamp
    private LocalDateTime dateUpdated;


    public MarathonDto getMarathonDto() {
        MarathonDto marathonDto = new MarathonDto();
        marathonDto.setId(id);
        marathonDto.setName(name);
        marathonDto.setLocation(location);
        marathonDto.setDate(date);
        marathonDto.setTime(time);
        marathonDto.setDescription(description);
        marathonDto.setMaxParticipants(maxParticipants);
        marathonDto.setActive(isActive);
        marathonDto.setRegistrationFee(registrationFee);
        marathonDto.setRegisteredParticipantsCount();
        return marathonDto;
    }

    public void incrementParticipantCount() {
        if (this.registeredParticipantsCount == null) {
            this.registeredParticipantsCount = 0;
        }
        this.registeredParticipantsCount++;
    }
}
