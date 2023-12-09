package com.recancheros.fieldsservice.services.impl;

import com.recancheros.fieldsservice.feign.sportcenterclient.SportCenterDto;
import com.recancheros.fieldsservice.feign.sportcenterclient.SportCenterServiceClient;
import com.recancheros.fieldsservice.feign.sportcenterclient.SportsDto;
import com.recancheros.fieldsservice.model.dto.FieldRequest;
import com.recancheros.fieldsservice.model.dto.FieldResponse;
import com.recancheros.fieldsservice.model.entity.Field;
import com.recancheros.fieldsservice.model.mapper.FieldMapper;
import com.recancheros.fieldsservice.repositories.FieldRepository;
import com.recancheros.fieldsservice.services.FieldService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FieldServiceImpl implements FieldService {
    private final FieldRepository fieldRepository;
    private final FieldMapper fieldMapper;
    private final SportCenterServiceClient sportCenterServiceClient;

    @Override
    public void addField(FieldRequest fieldRequest) {
        fieldRepository.save(fieldMapper.toEntity(fieldRequest));
    }

    @Override
    public List<FieldResponse> getFieldsBySportCenterId(Long sportCenterId) {
        List<Field> fields = fieldRepository.findBySportCenterId(sportCenterId);
        return fieldMapper.toFieldResponseList(fields);
    }

    @Override
    public FieldResponse getFieldBySportCenterIdAndFieldId(Long sportCenterId, Long fieldId) {
        Field field = fieldRepository.findBySportCenterIdAndId(sportCenterId, fieldId);
        SportCenterDto sportCenterDto = sportCenterServiceClient.getSportCenterById(field.getSportCenterId());
        SportsDto sportsDto = sportCenterServiceClient.getSportsById(field.getSportId());

        FieldResponse fieldResponse = null;

        if (field != null) {
            fieldResponse = fieldMapper.toFieldResponse(field);
            fieldResponse.setSportCenterName(sportCenterDto.getName());
            fieldResponse.setSportCenterAddress(sportCenterDto.getAddress());
            fieldResponse.setSportName(sportsDto.getName());
        }

        return fieldResponse;
    }
}
