package com.recancheros.fieldsservice.feign.sportcenterclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "sport-centers-service")
public interface SportCenterServiceClient {

    @GetMapping("/api/sportcenters/{sportCenterId}")
    SportCenterDto getSportCenterById(@PathVariable("sportCenterId") Long sportCenterId);

    @GetMapping("/api/sports/{sportId}")
    SportsDto getSportsById(@PathVariable("sportId") Long sportId);
}
