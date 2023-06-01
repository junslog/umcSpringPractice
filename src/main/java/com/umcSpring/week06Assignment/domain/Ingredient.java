package com.umcSpring.week06Assignment.domain;

import jakarta.persistence.*;

@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="INGREDIENT_ID")
    private Long id;

    private String name;

}
