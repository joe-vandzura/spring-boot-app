package com.joey.springbootapp.models;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class AppMembership {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private User user;

    private SocialMediaApp app;

    @Column(name = "access_token")
    private int accessToken;
}
