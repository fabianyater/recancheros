package com.recancheros.sportcenters.services.impl;

import com.recancheros.sportcenters.feign.fieldclient.FieldDto;
import com.recancheros.sportcenters.feign.fieldclient.FieldMapper;
import com.recancheros.sportcenters.feign.fieldclient.FieldServiceClient;
import com.recancheros.sportcenters.model.dto.SportCenterRequest;
import com.recancheros.sportcenters.model.dto.SportCenterResponse;
import com.recancheros.sportcenters.model.dto.SportResponse;
import com.recancheros.sportcenters.model.entity.SportCenter;
import com.recancheros.sportcenters.model.mapper.SportCenterMapper;
import com.recancheros.sportcenters.repositories.SportCenterRepository;
import com.recancheros.sportcenters.services.SportCenterService;
import com.recancheros.sportcenters.services.SportService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@AllArgsConstructor
@Transactional
@Service
public class SportCenterServiceImpl implements SportCenterService {
    private final SportCenterRepository sportCenterRepository;
    private final SportCenterMapper sportCenterMapper;
    private final FieldServiceClient fieldServiceClient;
    private final SportService sportService;
    private final FieldMapper fieldMapper;

    @Override
    public void addCenter(SportCenterRequest sportCenterRequest) {
        sportCenterRepository.save(sportCenterMapper.toEntity(sportCenterRequest));
    }

    @Override
    public Optional<SportCenterResponse> getSportCenterById(Long id) throws Exception {
        Optional<SportCenter> sportCenter = sportCenterRepository.findById(id);

        if (sportCenter.isEmpty()) {
            return Optional.empty();
        }

        List<FieldDto> fields = fieldServiceClient.getFieldsBySportCenterId(sportCenter.get().getId());
        SportCenterResponse sportCenterResponse = sportCenterMapper.toSportCenterResponse(sportCenter.get());

        for (FieldDto fieldDto : fields) {
            Optional<SportResponse> sportResponse = sportService.getSportById(fieldDto.getSportId());
            sportResponse.ifPresent(sport -> fieldDto.setSport(sport.getName()));
        }

        sportCenterResponse.setFields(fieldMapper.toFieldResponseList(fields));

        return Optional.of(sportCenterResponse);
    }

    @Override
    public List<SportCenterResponse> getAllSportCenters() {
        List<SportCenter> sportCenters = sportCenterRepository.findAll();
        return sportCenterMapper.toSportCenterResponseList(sportCenters);
    }
}
