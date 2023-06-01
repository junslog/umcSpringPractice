package com.umcSpring.week06Assignment.domain;

import jakarta.persistence.*;

@Entity
public class RecipeIngredient {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name="RECIPE_ID")
    private Recipe recipe;

    @ManyToOne
    @JoinColumn(name="INGREDIENT_ID")
    private Ingredient ingredient;

    private String quantity;


}
