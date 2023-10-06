package com.recancheros.sportcenters.controllers;

import com.recancheros.sportcenters.model.dto.SportCenterRequest;
import com.recancheros.sportcenters.model.dto.SportCenterResponse;
import com.recancheros.sportcenters.services.SportCenterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sportcenters")
public class SportCenterController {
    private final SportCenterService sportCenterService;

    public SportCenterController(SportCenterService sportCenterService) {
        this.sportCenterService = sportCenterService;
    }


    @PostMapping
    public ResponseEntity<Void> addSportCenter(@RequestBody SportCenterRequest sportCenterRequest) {
        sportCenterService.addCenter(sportCenterRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<SportCenterResponse>> getAllSportCenters() throws Exception {
        return new ResponseEntity<>(sportCenterService.getAllSportCenters(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SportCenterResponse> getSportCenterById(@PathVariable Long id) throws Exception {
        return sportCenterService.getSportCenterById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
