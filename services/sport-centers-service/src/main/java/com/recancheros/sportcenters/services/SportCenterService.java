package com.recancheros.sportcenters.services;

import com.recancheros.sportcenters.model.dto.SportCenterRequest;
import com.recancheros.sportcenters.model.dto.SportCenterResponse;

import java.util.Optional;

public interface SportCenterService {
    void addCenter(SportCenterRequest sportCenterRequest);
    Optional<SportCenterResponse> getSportCenterById(Long id) throws Exception;
}
