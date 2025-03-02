package com.kikoti.marathonbooking.services.participant;

import com.kikoti.marathonbooking.Dtos.MarathonRegistrationDto;
import com.kikoti.marathonbooking.entities.Marathon;
import com.kikoti.marathonbooking.entities.MarathonRegistration;
import com.kikoti.marathonbooking.entities.Users;
import com.kikoti.marathonbooking.exceptions.*;
import com.kikoti.marathonbooking.repositories.MarathonRegistrationRepository;
import com.kikoti.marathonbooking.repositories.MarathonRepository;
import com.kikoti.marathonbooking.services.jwt.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class MarathonRegistrationServiceImpl implements MarathonRegistrationService {

    private final MarathonRepository marathonRepository;
    private final MarathonRegistrationRepository registrationRepository;
    private final UserService userService;

    @Override
    @Transactional
    public MarathonRegistration registerUserToMarathon(MarathonRegistrationDto registrationDto)
            throws MarathonNotFoundException, AlreadyRegisteredException, MarathonNotActiveException, MarathonFullException {

        // Find user by ID
        Users user = userService.findById(MarathonRegistrationDto.getUserId())
                .orElseThrow(() -> new UserNotFoundException("User not found with ID: " + registrationDto.getUserId()));

        // Find marathon by ID
        Marathon marathon = marathonRepository.findById(registrationDto.getMarathonId())
                .orElseThrow(() -> new MarathonNotFoundException("Marathon not found with ID: " + registrationDto.getMarathonId()));

        // Check if marathon is active
        if (!marathon.isActive()) {
            throw new MarathonNotActiveException("Marathon is not active for registration");
        }

        // Check if marathon is full
        if (marathon.getRegisteredParticipantsCount() >= marathon.getMaxParticipants()) {
            throw new MarathonFullException("Marathon is already full");
        }

        // Check if user is already registered
        if (registrationRepository.existsByMarathonAndUser(marathon, user)) {
            throw new AlreadyRegisteredException("User is already registered for this marathon");
        }

        // Create and save new registration
        MarathonRegistration registration = new MarathonRegistration();
        registration.setMarathon(marathon);
        registration.setUser(user);
        registration.setRegistrationDate(LocalDateTime.now());

        // Increment participant count
        marathon.setRegisteredParticipantsCount(marathon.getRegisteredParticipantsCount() + 1);
        marathonRepository.save(marathon);

        return registrationRepository.save(registration);
    }
}
