package com.kikoti.marathonbooking.controllers;

import com.kikoti.marathonbooking.Dtos.MarathonDto;
import com.kikoti.marathonbooking.services.admin.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin")
public class AdminController {

    private final AdminService adminService;

    @PostMapping("/marathon")
    public ResponseEntity<?> createMarathon(@ModelAttribute MarathonDto marathonDto) {
        boolean success = adminService.createMarathon(marathonDto);
        if (success)
            return ResponseEntity.status(HttpStatus.CREATED).build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

 @GetMapping("/marathons")
public ResponseEntity<List<MarathonDto>> getAllMarathons() {
    List<MarathonDto> marathonDtoList = adminService.getAllMarathons();
    return ResponseEntity.ok(marathonDtoList);
}

    @DeleteMapping("/marathon/{marathonId}")
    public ResponseEntity<Void> deleteMarathon(@PathVariable Long marathonId) {
        adminService.deleteMarathon(marathonId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/marathon/{marathonId}")
    public ResponseEntity<MarathonDto> getMarathonById(@PathVariable Long marathonId) {
        MarathonDto marathonDto = adminService.getMarathonById(marathonId);
        if (marathonDto != null) return ResponseEntity.ok(marathonDto);
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/marathon/{marathonId}")
    public ResponseEntity<?> updateMarathon(@PathVariable Long marathonId, @ModelAttribute MarathonDto marathonDto) throws IOException {
        try {
            boolean success = adminService.updateMarathon(marathonId, marathonDto);
            if (success) return ResponseEntity.ok().build();
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
        }
    }


}

