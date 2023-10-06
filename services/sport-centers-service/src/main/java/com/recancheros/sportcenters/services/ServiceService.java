package com.recancheros.sportcenters.services;

import com.recancheros.sportcenters.model.dto.ServiceRequest;
import com.recancheros.sportcenters.model.dto.ServiceResponse;

import java.util.List;

public interface ServiceService {
    void addService(ServiceRequest serviceRequest);
    List<ServiceResponse> getAllServicesBySportCenterId(Long sportCenterId);
}
