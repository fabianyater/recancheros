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
import java.util.Optional;

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
    public Optional<SportResponse> getSportById(Long sportId) throws Exception {
        Optional<Sport> sport = Optional.ofNullable(sportsRepository.findById(sportId).orElseThrow(Exception::new));
        SportResponse sportResponse = null;

        if (sport.isPresent()) {
            sportResponse = sportMapper.toSportResponse(sport.get());
        }

        return Optional.ofNullable(sportResponse);
    }

    @Override
    public List<SportResponse> getAllSportsBySportCenterId(Long sportCenterId) {
        List<Sport> sports = sportsRepository.findBySportCenter_Id(sportCenterId);
        return sportMapper.toSportResponseList(sports);
    }
}
