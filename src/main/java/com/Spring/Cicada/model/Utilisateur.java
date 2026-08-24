package com.Spring.Cicada.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Utilisateur {

    @Id
    @GeneratedValue
    private Long id;
    private String nom;
    private String email;
    private String role;
    private String motDePasse;

    public Utilisateur() {
    }
}