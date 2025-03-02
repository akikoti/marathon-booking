package com.kikoti.marathonbooking.repositories;

import com.kikoti.marathonbooking.entities.Marathon;
import com.kikoti.marathonbooking.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MarathonRepository extends JpaRepository<Marathon, Long> {

    boolean existsByUserAndMarathon(Users user, Marathon marathon);

    @Modifying
    @Query("UPDATE Marathon m SET m.registeredParticipantsCount = m.registeredParticipantsCount + 1 " +
            "WHERE m.id = :marathonId AND m.registeredParticipantsCount < m.maxParticipants AND m.isActive = true")
    int incrementParticipantsCountIfPossible(@Param("marathonId") Long marathonId);
}
