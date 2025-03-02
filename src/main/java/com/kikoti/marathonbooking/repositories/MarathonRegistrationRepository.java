package com.kikoti.marathonbooking.repositories;

import com.kikoti.marathonbooking.entities.Marathon;
import com.kikoti.marathonbooking.entities.MarathonRegistration;
import com.kikoti.marathonbooking.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarathonRegistrationRepository extends JpaRepository<MarathonRegistration, Long> {
    boolean existsByMarathonAndUser(Marathon marathon, Users user);
}
