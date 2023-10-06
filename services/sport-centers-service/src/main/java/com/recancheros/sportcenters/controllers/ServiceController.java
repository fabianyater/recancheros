package com.recancheros.sportcenters.controllers;

import com.recancheros.sportcenters.model.dto.ServiceRequest;
import com.recancheros.sportcenters.model.dto.ServiceResponse;
import com.recancheros.sportcenters.services.ServiceService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sport-centers-service/api/sportcenters/services")
@AllArgsConstructor
public class ServiceController {
    private final ServiceService service;

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Void> addSportCenterService(@RequestBody ServiceRequest serviceRequest) {
        service.addService(serviceRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{sportCenterId}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<List<ServiceResponse>> getAllSportCenterServices(@PathVariable("sportCenterId") Long sportCenterId) throws Exception {
        return new ResponseEntity<>(service.getAllServicesBySportCenterId(sportCenterId), HttpStatus.OK);
    }
}
