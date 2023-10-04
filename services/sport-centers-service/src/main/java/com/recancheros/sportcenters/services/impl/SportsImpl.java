package com.recancheros.sportcenters.services.impl;

import com.recancheros.sportcenters.model.dto.SportRequest;
import com.recancheros.sportcenters.model.entity.Sports;
import com.recancheros.sportcenters.model.mapper.SportMapper;
import com.recancheros.sportcenters.repositories.SportsRepository;
import com.recancheros.sportcenters.services.SportsService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class SportsImpl implements SportsService {
    private final SportsRepository sportsRepository;
    private final SportMapper sportMapper;

    @Override
    public void addSport(SportRequest sportRequest) {
        sportsRepository.save(sportMapper.toEntity(sportRequest));
    }

    @Override
    public List<Sports> getAllSports() {
        return sportsRepository.findAll();
    }
}
