package com.recancheros.sportcenters.model.mapper;

import com.recancheros.sportcenters.model.dto.ServiceRequest;
import com.recancheros.sportcenters.model.dto.ServiceResponse;
import com.recancheros.sportcenters.model.dto.SportRequest;
import com.recancheros.sportcenters.model.dto.SportResponse;
import com.recancheros.sportcenters.model.entity.Service;
import com.recancheros.sportcenters.model.entity.Sport;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ServiceMapper {
    @Mapping(target = "sportCenter.id", source = "sportCenterId")
    Service toEntity(ServiceRequest serviceRequest);

    ServiceResponse toServiceResponse(Service service);

    List<ServiceResponse> toServiceResponseList(List<Service> services);
}
