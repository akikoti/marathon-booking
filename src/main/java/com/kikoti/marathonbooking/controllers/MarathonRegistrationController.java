package com.kikoti.marathonbooking.controllers;

import com.kikoti.marathonbooking.Dtos.MarathonRegistrationDto;
import com.kikoti.marathonbooking.entities.MarathonRegistration;
import com.kikoti.marathonbooking.exceptions.*;
import com.kikoti.marathonbooking.services.participant.MarathonRegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/marathon-registration")
@RequiredArgsConstructor
public class MarathonRegistrationController {

    private final MarathonRegistrationService registrationService;

    @PostMapping("/register")
    public ResponseEntity<MarathonRegistration> registerUserToMarathon(@RequestBody MarathonRegistrationDto registrationDto)
            throws MarathonNotFoundException, AlreadyRegisteredException, MarathonNotActiveException, MarathonFullException {
        MarathonRegistration registration = registrationService.registerUserToMarathon(registrationDto);
        return ResponseEntity.ok(registration);
    }
}
