package com.joey.springbootapp.models;

import jakarta.persistence.*;

@Entity
@Table(name = "social_media_apps")
public class SocialMediaApp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;
}
