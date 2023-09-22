package com.recancheros.users.feign;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SportCenterDTO {
    private String name;
    private String address;
    private String description;
    private String numberPhone;
    private String comment;
}
