package com.recancheros.users.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "sport-centers-service")
public interface SportCenterClient {

    @PostMapping("/sport-centers-service/api/sportcenters/")
    SportCenterDTO addSportCenter();
}
