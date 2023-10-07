package com.recancheros.sportcenters.feign.fieldclient;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FieldDto {
    private Long id;
    private String name;
    private Long sportCenterId;
    private Long sportId;
    private String sport;
}
