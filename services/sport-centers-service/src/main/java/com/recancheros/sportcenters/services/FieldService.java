package com.recancheros.sportcenters.services;

import com.recancheros.sportcenters.model.dto.FieldRequest;
import com.recancheros.sportcenters.model.dto.FieldResponse;

import java.util.List;

public interface FieldService {
    void addField(FieldRequest fieldRequest);
    List<FieldResponse> getFieldsBySportCenterId(Long sportCenterId);
    FieldResponse getFieldBySportCenterIdAndFieldId(Long sportCenterId, Long fieldId);
}
