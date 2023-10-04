package com.recancheros.sportcenters.controllers;

import com.recancheros.sportcenters.model.dto.SportRequest;
import com.recancheros.sportcenters.model.entity.Sports;
import com.recancheros.sportcenters.services.SportsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sport-centers-service/api/sports")
public class SportsController {
    private final SportsService sportsService;

    public SportsController(SportsService sportsService) {
        this.sportsService = sportsService;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Void> addSport(@RequestBody SportRequest sportRequest) {
        sportsService.addSport(sportRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<Sports>> getAllSports() {
        return new ResponseEntity<>(sportsService.getAllSports(), HttpStatus.OK);
    }
}
