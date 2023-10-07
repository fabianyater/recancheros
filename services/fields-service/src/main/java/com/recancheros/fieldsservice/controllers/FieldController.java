package com.recancheros.fieldsservice.controllers;

import com.recancheros.fieldsservice.model.dto.FieldRequest;
import com.recancheros.fieldsservice.model.dto.FieldResponse;
import com.recancheros.fieldsservice.services.FieldService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fields")
@AllArgsConstructor
public class FieldController {
    private final FieldService fieldService;

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Void> addSport(@RequestBody FieldRequest fieldRequest) {
        fieldService.addField(fieldRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{sportCenterId}")
    public ResponseEntity<List<FieldResponse>> getFieldsBySportCenterId(@PathVariable("sportCenterId") Long sportCenterId) {
        return new ResponseEntity<>(fieldService.getFieldsBySportCenterId(sportCenterId), HttpStatus.OK);
    }

    @GetMapping("/{sportCenterId}/{fieldId}")
    public ResponseEntity<FieldResponse> getFieldBySportCenterIdAndSportId(
            @PathVariable Long sportCenterId,
            @PathVariable Long fieldId) throws Exception {
        return new ResponseEntity<>(fieldService.getFieldBySportCenterIdAndFieldId(sportCenterId, fieldId), HttpStatus.OK);
    }
}
