package com.recancheros.sportcenters.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "fields")
@Getter
@Setter
public class Field {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "sportcenter_id")
    private SportCenter sportCenter;

    @ManyToOne
    @JoinColumn(name = "sport_id")
    private Sport sport;

}
