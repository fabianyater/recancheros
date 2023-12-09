package com.recancheros.fieldsservice.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FieldResponse {
    private Long id;
    private String name;
    private Long sportCenterId;
    private Long sportId;
    private String sportName;
    private String sportCenterName;
    private String sportCenterAddress;
}
