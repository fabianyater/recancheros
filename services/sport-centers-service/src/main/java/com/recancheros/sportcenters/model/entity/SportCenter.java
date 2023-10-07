package com.recancheros.sportcenters.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "sportcenters")
@Getter
@Setter
public class SportCenter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "numberPhone", nullable = false)
    private String numberPhone;

    @Column(name = "comment")
    private String comment;

    @OneToMany(mappedBy = "sportCenter", orphanRemoval = true)
    private Set<Service> services = new LinkedHashSet<>();

    @OneToMany(mappedBy = "sportCenter", orphanRemoval = true)
    private Set<Sport> sports = new LinkedHashSet<>();
}
