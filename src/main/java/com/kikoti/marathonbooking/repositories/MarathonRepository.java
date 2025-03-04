package com.kikoti.marathonbooking.repositories;

import com.kikoti.marathonbooking.entities.Marathon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarathonRepository extends JpaRepository<Marathon, Long> {
}
