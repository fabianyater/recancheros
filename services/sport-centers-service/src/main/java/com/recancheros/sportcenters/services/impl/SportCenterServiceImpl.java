package com.recancheros.sportcenters.services.impl;

import com.recancheros.sportcenters.model.dto.SportCenterRequest;
import com.recancheros.sportcenters.model.dto.SportCenterResponse;
import com.recancheros.sportcenters.model.entity.SportCenter;
import com.recancheros.sportcenters.model.mapper.SportCenterMapper;
import com.recancheros.sportcenters.repositories.SportCenterRepository;
import com.recancheros.sportcenters.services.SportCenterService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@AllArgsConstructor
@Transactional
@Service
public class SportCenterServiceImpl implements SportCenterService {
    private final SportCenterRepository sportCenterRepository;
    private final SportCenterMapper sportCenterMapper;
    @Override
    public void addCenter(SportCenterRequest sportCenterRequest) {
        sportCenterRepository.save(sportCenterMapper.toEntity(sportCenterRequest));
    }

    @Override
    public Optional<SportCenterResponse> getSportCenterById(Long id) throws Exception {
        Optional<SportCenter> sportCenter = Optional.ofNullable(sportCenterRepository.findById(id).orElseThrow(Exception::new));
        SportCenterResponse sportCenterResponse = null;

        if (sportCenter.isPresent()) {
            sportCenterResponse = sportCenterMapper.toSportCenterResponse(sportCenter.get());
        }

        return Optional.ofNullable(sportCenterResponse);
    }
}
