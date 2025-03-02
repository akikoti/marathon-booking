package com.kikoti.marathonbooking.services.participant;

import com.kikoti.marathonbooking.Dtos.MarathonRegistrationDto;
import com.kikoti.marathonbooking.entities.MarathonRegistration;
import com.kikoti.marathonbooking.exceptions.*;
import jakarta.validation.Valid;

public interface MarathonRegistrationService {
    MarathonRegistration registerUserToMarathon(@Valid MarathonRegistrationDto registrationDto)
            throws MarathonNotFoundException, AlreadyRegisteredException, MarathonNotActiveException, MarathonFullException;
}
