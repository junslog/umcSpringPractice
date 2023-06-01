package com.umcSpring.week06Assignment.domain;

import jakarta.persistence.*;

@Entity
public class Step {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name="RECIPE_ID")
    private Recipe recipe;

    private Integer order;

    private String imageUrl;

    private String description;

}
