package com.example.demo.models;


import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "casinos")
@Entity
public class Casino {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String name;

    @Column
    private String country;

    @Column
    private double entry_price;

    @Column
    private String best_drink;

    @Column
    private String main_game;



}
