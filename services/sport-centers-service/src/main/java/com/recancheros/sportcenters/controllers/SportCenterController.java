package com.recancheros.sportcenters.controllers;

import com.recancheros.sportcenters.model.dto.SportCenterRequest;
import com.recancheros.sportcenters.model.dto.SportCenterResponse;
import com.recancheros.sportcenters.model.entity.SportCenter;
import com.recancheros.sportcenters.services.SportCenterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/sportcenters")
public class SportCenterController {
    private final SportCenterService sportCenterService;

    public SportCenterController(SportCenterService sportCenterService) {
        this.sportCenterService = sportCenterService;
    }


    @PostMapping
    public ResponseEntity<Void> addCenter(@RequestBody SportCenterRequest sportCenterRequest) {
        sportCenterService.addCenter(sportCenterRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SportCenterResponse> getSportCenterById(@PathVariable Long id) throws Exception {
        return sportCenterService.getSportCenterById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
