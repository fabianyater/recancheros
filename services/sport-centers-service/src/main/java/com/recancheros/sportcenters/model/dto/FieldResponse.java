package com.recancheros.sportcenters.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FieldResponse {
    private String name;
    private String surface;
    private String type;
    private String availability;
    private String price;

}
