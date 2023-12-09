package com.recancheros.sportcenters.controllers;

import com.recancheros.sportcenters.model.dto.SportRequest;
import com.recancheros.sportcenters.model.dto.SportResponse;
import com.recancheros.sportcenters.services.SportService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sports")
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

    @GetMapping("/{sportId}")
    public ResponseEntity<SportResponse> getSportBySportId(@PathVariable("sportId") Long sportId) throws Exception {
        Optional<SportResponse> sportResponse = sportService.getSportById(sportId);

        if (sportResponse.isPresent()) {
            SportResponse newSportResponse = sportResponse.get();
            return new ResponseEntity<>(newSportResponse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/sportcenter/{sportCenterId}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<List<SportResponse>> getAllSportsBySportCenterId(@PathVariable("sportCenterId") Long sportCenterId) {
        return new ResponseEntity<>(sportService.getAllSportsBySportCenterId(sportCenterId), HttpStatus.OK);
    }
}
