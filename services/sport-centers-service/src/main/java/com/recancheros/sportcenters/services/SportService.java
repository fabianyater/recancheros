package com.recancheros.sportcenters.services;

import com.recancheros.sportcenters.model.dto.SportRequest;
import com.recancheros.sportcenters.model.dto.SportResponse;

import java.util.List;
import java.util.Optional;

public interface SportService {
    void addSport(SportRequest sportRequest);
    Optional<SportResponse> getSportById(Long sportId) throws Exception;
    List<SportResponse> getAllSportsBySportCenterId(Long sportCenterId);
}
