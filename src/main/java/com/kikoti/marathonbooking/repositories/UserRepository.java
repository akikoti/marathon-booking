package com.kikoti.marathonbooking.repositories;

import com.kikoti.marathonbooking.enams.UserRole;
import com.kikoti.marathonbooking.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    Optional<Users> findFirstByEmail(String email);

    Users findByUserRole(UserRole userRole);

}
