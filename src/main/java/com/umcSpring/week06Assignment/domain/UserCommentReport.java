package com.umcSpring.week06Assignment.domain;

import jakarta.persistence.*;

@Entity
public class UserCommentReport {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name="USER_ID")
    private User user;

    @ManyToOne
    @JoinColumn(name="COMMNET_ID")
    private Comment comment;

    private String reportReason;

}
