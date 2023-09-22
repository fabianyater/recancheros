package com.recancheros.sportcenters.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "sports")
@Getter
@Setter
public class Sports {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "amount")
    private Integer amount;

    @ManyToOne
    @JoinColumn(name = "sportcenter_id")
    private SportCenter sportCenter;

}
