package com.recancheros.sportcenters.services.impl;

import com.recancheros.sportcenters.model.dto.SportRequest;
import com.recancheros.sportcenters.model.dto.SportResponse;
import com.recancheros.sportcenters.model.entity.Sport;
import com.recancheros.sportcenters.model.mapper.SportMapper;
import com.recancheros.sportcenters.repositories.SportsRepository;
import com.recancheros.sportcenters.services.SportService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class SportImpl implements SportService {
    private final SportsRepository sportsRepository;
    private final SportMapper sportMapper;

    @Override
    public void addSport(SportRequest sportRequest) {
        sportsRepository.save(sportMapper.toEntity(sportRequest));
    }

    @Override
    public List<SportResponse> getAllSports() {
        List<Sport> sports = sportsRepository.findAll();
        return sportMapper.toSportResponseList(sports);
    }
}
