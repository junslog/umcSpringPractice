package com.umcSpring.week06Assignment.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class UserRecipeLike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="USER_ID")
    private User user;

    @ManyToOne
    @JoinColumn(name="RECIPE_ID")
    private Recipe recipe;

    public UserRecipeLike(User user, Recipe recipe){
        this.user = user;
        this.recipe = recipe;
    }

}
