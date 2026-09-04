package com.Spring.Cicada.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import jakarta.validation.constraints.NotBlank;


@Entity
@Getter
@Setter
public class Incident {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank(message = "Le titre est obligatoire")
    private String titre;

    @NotBlank(message = "La description est obligatoire")
    private String description;

    @Enumerated(EnumType.STRING)
    private Statut statut;

    @Enumerated(EnumType.STRING)
    private Priorite priorite;


    private LocalDateTime dateCreation;

    @ManyToOne
    private Utilisateur declarerPar;

    @ManyToOne
    private Probleme probleme;
    

    public Incident() {
        this.statut = Statut.NOUVEAU;
        this.dateCreation = LocalDateTime.now();
    }

    public enum Statut {
        NOUVEAU, EN_COURS, RESOLU, FERME
    }

    public enum Priorite {
        BASSE, MOYENNE, HAUTE, CRITIQUE
    }
}