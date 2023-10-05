package com.recancheros.sportcenters.model.mapper;

import com.recancheros.sportcenters.model.dto.SportRequest;
import com.recancheros.sportcenters.model.dto.SportResponse;
import com.recancheros.sportcenters.model.entity.Sport;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SportMapper {

    @Mapping(target = "sportCenter.id", source = "sportCenterId")
    Sport toEntity(SportRequest sportRequest);

    SportResponse toSportResponse(Sport sport);

    List<SportResponse> toSportResponseList(List<Sport> sports);

}
