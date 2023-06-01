package com.umcSpring.week06Assignment.domain;

import jakarta.persistence.*;

import javax.annotation.processing.Generated;

@Entity
public class UserRecipeChallenge {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name="USER_ID")
    private User user;

    @ManyToOne
    @JoinColumn(name="RECIPE_ID")
    private Recipe recipe;

    private Boolean isFinished;

}
