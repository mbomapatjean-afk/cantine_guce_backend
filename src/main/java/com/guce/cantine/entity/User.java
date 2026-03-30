package com.guce.cantine.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String emailGuce;
    private String numeroBadge;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;
}
