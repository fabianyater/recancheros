package com.recancheros.sportcenters.controllers;

import com.recancheros.sportcenters.model.dto.SportRequest;
import com.recancheros.sportcenters.model.dto.SportResponse;
import com.recancheros.sportcenters.model.entity.Sport;
import com.recancheros.sportcenters.services.SportService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sport-centers-service/api/sports")
public class SportsController {
    private final SportService sportService;

    public SportsController(SportService sportService) {
        this.sportService = sportService;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Void> addSport(@RequestBody SportRequest sportRequest) {
        sportService.addSport(sportRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<SportResponse>> getAllSports() {
        return new ResponseEntity<>(sportService.getAllSports(), HttpStatus.OK);
    }
}
