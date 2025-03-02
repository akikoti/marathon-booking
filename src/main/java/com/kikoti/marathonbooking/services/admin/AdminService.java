package com.kikoti.marathonbooking.services.admin;

import com.kikoti.marathonbooking.Dtos.MarathonDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AdminService {
    boolean createMarathon(MarathonDto marathonDto);

    List<MarathonDto> getAllMarathons();
    void deleteMarathon(Long MarathonId);

    MarathonDto getMarathonById(Long marathonId);

    boolean updateMarathon(Long marathonId, MarathonDto marathonDto);
}
