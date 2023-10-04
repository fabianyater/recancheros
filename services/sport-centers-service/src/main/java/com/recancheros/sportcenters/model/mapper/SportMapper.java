package com.recancheros.sportcenters.model.mapper;

import com.recancheros.sportcenters.model.dto.SportRequest;
import com.recancheros.sportcenters.model.entity.Sports;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SportMapper {

    @Mapping(target = "sportCenter.id", source = "sportCenterId")
    Sports toEntity(SportRequest sportRequest);

}
