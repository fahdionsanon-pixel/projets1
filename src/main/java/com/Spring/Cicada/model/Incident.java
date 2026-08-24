package com.Spring.Cicada.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Incident {

    @Id
    @GeneratedValue
    private Long id;
    private String titre;
    private String description;

    @Enumerated(EnumType.STRING)
    private Statut statut;

    @Enumerated(EnumType.STRING)
    private Priorite priorite;

    private LocalDateTime dateCreation;

    @ManyToOne
    private Utilisateur declarerPar;

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