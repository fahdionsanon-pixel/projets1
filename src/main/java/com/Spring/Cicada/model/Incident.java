package com.Spring.Cicada.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
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

    private LocalDateTime DateCreation;

    public Incident() {
        this.statut = Statut.NOUVEAU;
        this.DateCreation = LocalDateTime.now();
    }

    public LocalDateTime getDateCreation() {
        return DateCreation;
    }

    private void setDateCreation(LocalDateTime dateCreation) {
        this.DateCreation = dateCreation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Statut getStatut() {
        return statut;
    }

    public void setStatut(Statut statut) {
        this.statut = statut;
    }

    public Priorite getPriorite() {
        return priorite;
    }

    public void setPriorite(Priorite priorite) {
        this.priorite = priorite;
    }

    public enum Statut {
        NOUVEAU, EN_COURS, RESOLU, FERME
    }

    public enum Priorite {
        BASSE, MOYENNE, HAUTE, CRITIQUE
    }
}