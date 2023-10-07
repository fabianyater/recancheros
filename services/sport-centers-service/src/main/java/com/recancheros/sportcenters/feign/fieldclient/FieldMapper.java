package com.recancheros.sportcenters.feign.fieldclient;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface FieldMapper {
    FieldResponse toFieldResponse(FieldDto fieldDto);
    List<FieldResponse> toFieldResponseList(List<FieldDto> fieldDto);
}
