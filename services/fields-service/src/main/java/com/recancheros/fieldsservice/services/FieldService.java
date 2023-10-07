package com.recancheros.fieldsservice.services;

import com.recancheros.fieldsservice.model.dto.FieldRequest;
import com.recancheros.fieldsservice.model.dto.FieldResponse;

import java.util.List;

public interface FieldService {
    void addField(FieldRequest fieldRequest);
    List<FieldResponse> getFieldsBySportCenterId(Long sportCenterId);
    FieldResponse getFieldBySportCenterIdAndFieldId(Long sportCenterId, Long fieldId);
}
