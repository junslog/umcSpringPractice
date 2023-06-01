package com.umcSpring.week06Assignment.domain;

import jakarta.persistence.*;

@Entity
public class UserBeverage {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name="USER_ID")
    private User user;

    @ManyToOne
    @JoinColumn(name="BEV_ID")
    private Beverage beverage;

}
