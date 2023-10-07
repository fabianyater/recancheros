package com.recancheros.sportcenters.feign.fieldclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "fields-service")
public interface FieldServiceClient {

    @GetMapping("/api/fields/{sportCenterId}")
    List<FieldDto> getFieldsBySportCenterId(@PathVariable("sportCenterId") Long sportCenterId);
}
