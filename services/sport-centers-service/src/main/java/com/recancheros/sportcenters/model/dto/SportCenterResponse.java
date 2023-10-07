package com.recancheros.sportcenters.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SportCenterResponse {
    private String name;
    private String address;
    private String description;
    private String numberPhone;
    private List<SportResponse> sports;
    private List<ServiceResponse> services;
}
