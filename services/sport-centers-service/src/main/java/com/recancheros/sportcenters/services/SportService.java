package com.recancheros.sportcenters.services;

import com.recancheros.sportcenters.model.dto.SportRequest;
import com.recancheros.sportcenters.model.dto.SportResponse;
import com.recancheros.sportcenters.model.entity.Sport;

import java.util.List;

public interface SportService {
    void addSport(SportRequest sportRequest);

    List<SportResponse> getAllSports();
}
