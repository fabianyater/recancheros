package com.recancheros.sportcenters.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "fields")
@Getter
@Setter
public class Fields {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surface", nullable = false)
    private String surface;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "availability", nullable = false)
    private String availability;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "comment")
    private String comment;

    @ManyToOne
    @JoinColumn(name = "sportcenter_id")
    private SportCenter sportCenter;

}
