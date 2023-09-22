package com.recancheros.users.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "sport-centers")
public interface SportCenterClient {

    @GetMapping("/api/sportcenters/{id}")
    SportCenterDTO getSportCenterById(@PathVariable Long id);
}
