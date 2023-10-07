package com.recancheros.fieldsservice.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FieldRequest {
    private String name;
    private Long sportCenterId;
    private Long sportId;
}
