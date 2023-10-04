package com.recancheros.sportcenters.services;

import com.recancheros.sportcenters.model.dto.SportRequest;
import com.recancheros.sportcenters.model.entity.Sports;

import java.util.List;

public interface SportsService {
    void addSport(SportRequest sportRequest);

    List<Sports> getAllSports();
}
