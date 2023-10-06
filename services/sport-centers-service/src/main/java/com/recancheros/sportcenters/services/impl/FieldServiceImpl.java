package com.recancheros.sportcenters.services.impl;

import com.recancheros.sportcenters.model.dto.FieldRequest;
import com.recancheros.sportcenters.model.dto.FieldResponse;
import com.recancheros.sportcenters.model.entity.Field;
import com.recancheros.sportcenters.model.mapper.FieldMapper;
import com.recancheros.sportcenters.repositories.FieldRepository;
import com.recancheros.sportcenters.services.FieldService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FieldServiceImpl implements FieldService {
    private final FieldRepository fieldRepository;
    private final FieldMapper fieldMapper;

    @Override
    public void addField(FieldRequest fieldRequest) {
        fieldRepository.save(fieldMapper.toEntity(fieldRequest));
    }

    @Override
    public List<FieldResponse> getFieldsBySportCenterId(Long sportCenterId) {
        List<Field> fields = fieldRepository.findBySportCenter_Id(sportCenterId);
        return fieldMapper.toFieldResponseList(fields);
    }

    @Override
    public FieldResponse getFieldBySportCenterIdAndFieldId(Long sportCenterId, Long fieldId) {
        Field field = fieldRepository.findBySportCenter_IdAndId(sportCenterId, fieldId);
        FieldResponse fieldResponse = null;

        if (field != null) {
            fieldResponse = fieldMapper.toFieldResponse(field);
        }

        return fieldResponse;
    }
}
