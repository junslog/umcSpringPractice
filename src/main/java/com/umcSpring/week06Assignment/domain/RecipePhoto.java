package com.umcSpring.week06Assignment.domain;

import jakarta.persistence.*;

@Entity
public class RecipePhoto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="RECIPE_PHOTO_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name="RECIPE_ID")
    private Recipe recipe;

    private Integer order;

    private String photoUrl;

}
