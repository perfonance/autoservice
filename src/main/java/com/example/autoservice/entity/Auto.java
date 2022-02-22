package com.example.autoservice.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Auto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Brand brand;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    private String plateNumber;

    @Column(nullable = false)
    private String vin;

    public Auto() {

    }
}
