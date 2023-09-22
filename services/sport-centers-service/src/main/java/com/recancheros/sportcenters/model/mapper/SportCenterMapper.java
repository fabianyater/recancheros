package com.recancheros.sportcenters.model.mapper;

import com.recancheros.sportcenters.model.dto.SportCenterRequest;
import com.recancheros.sportcenters.model.dto.SportCenterResponse;
import com.recancheros.sportcenters.model.entity.SportCenter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SportCenterMapper {
    SportCenterMapper INSTANCE = Mappers.getMapper(SportCenterMapper.class);

    SportCenter toEntity(SportCenterRequest sportCenterRequest);

    SportCenterResponse toSportCenterResponse(SportCenter sportCenter);

}

