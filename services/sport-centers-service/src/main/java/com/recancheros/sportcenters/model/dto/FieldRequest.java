package com.recancheros.sportcenters.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FieldRequest {
    private String name;
    private Long sportId;
    private Long sportCenterId;
}
