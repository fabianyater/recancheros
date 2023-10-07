package com.recancheros.sportcenters.feign.fieldclient;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FieldResponse {
    private Long id;
    private String name;
    private String sport;
}
