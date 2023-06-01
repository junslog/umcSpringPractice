package com.umcSpring.week06Assignment.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@Getter
public class User {

    @Id
    @Column(name = "USER_ID")
    private Long userId;

    private String name;

    private String nickname;

    private String birth;

    private String sex;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime updatedAt;

    private LocalDateTime dormantAt;

    private String authProvider;

    private Boolean servicePolicy;

    private Boolean privacyPolicy;

    private Boolean isAdmin;

}
