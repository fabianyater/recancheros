package com.recancheros.sportcenters.services.impl;

import com.recancheros.sportcenters.model.dto.ServiceRequest;
import com.recancheros.sportcenters.model.dto.ServiceResponse;
import com.recancheros.sportcenters.model.mapper.ServiceMapper;
import com.recancheros.sportcenters.repositories.ServiceRepository;
import com.recancheros.sportcenters.services.ServiceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ServiceServiceImpl implements ServiceService {
    private final ServiceRepository serviceRepository;
    private final ServiceMapper serviceMapper;

    @Override
    public void addService(ServiceRequest serviceRequest) {
        serviceRepository.save(serviceMapper.toEntity(serviceRequest));
    }

    @Override
    public List<ServiceResponse> getAllServicesBySportCenterId(Long sportCenterId) {
        List<com.recancheros.sportcenters.model.entity.Service> services = serviceRepository.findBySportCenter_Id(sportCenterId);
        return serviceMapper.toServiceResponseList(services);
    }
}
