package com.recancheros.fieldsservice.feign.sportcenterclient;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SportCenterDto {
    private Long id;
    private String name;
    private String address;
}
