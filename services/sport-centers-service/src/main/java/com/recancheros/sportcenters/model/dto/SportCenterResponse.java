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
    private List<SportsResponse> sports;
    private List<ServicesResponse> services;
    private List<FieldsResponse> fields;
}
