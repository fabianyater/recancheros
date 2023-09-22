package com.recancheros.sportcenters.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SportCenterRequest {
    private String name;
    private String address;
    private String description;
    private String numberPhone;
    private String comment;
}
