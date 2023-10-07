package com.recancheros.fieldsservice.model.mapper;

import com.recancheros.fieldsservice.model.dto.FieldRequest;
import com.recancheros.fieldsservice.model.dto.FieldResponse;
import com.recancheros.fieldsservice.model.entity.Field;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface FieldMapper {
    Field toEntity(FieldRequest fieldRequest);

    FieldResponse toFieldResponse(Field field);

    List<FieldResponse> toFieldResponseList(List<Field> fields);
}
