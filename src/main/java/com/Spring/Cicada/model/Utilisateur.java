package com.Spring.Cicada.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;


@Entity
@Getter
@Setter
public class Utilisateur {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank(message = "Le nom est obligatoire")
    private String nom;

    @Email(message = "L'email doit être valide")
    @NotBlank(message = "l'email est obligatoire")
    private String email;
    
    @NotBlank(message = "Le mot de passe est obligatoire")
    @Size(min = 6, message = "Le mot de passe doit contenir au moins 6 caractères")
    private String motDePasse;

    @Enumerated(EnumType.STRING)
    private Role role;

    public Utilisateur() {
    }

    public enum Role {
        ADMIN, TECHNICIEN, UTILISATEUR
    }
}