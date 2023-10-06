package com.recancheros.sportcenters.model.mapper;

import com.recancheros.sportcenters.model.dto.FieldRequest;
import com.recancheros.sportcenters.model.dto.FieldResponse;
import com.recancheros.sportcenters.model.entity.Field;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface FieldMapper {
    @Mapping(target = "sportCenter.id", source = "sportCenterId")
    @Mapping(target = "sport.id", source = "sportId")
    Field toEntity(FieldRequest fieldRequest);

    @Mapping(target = "sportCenterId", source = "sportCenter.id")
    @Mapping(target = "sportName", source = "sport.name")
    FieldResponse toFieldResponse(Field field);

    List<FieldResponse> toFieldResponseList(List<Field> fields);
}
