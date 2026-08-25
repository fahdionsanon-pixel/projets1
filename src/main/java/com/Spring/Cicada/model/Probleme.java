package com.Spring.Cicada.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Entity
@Getter
@Setter

public class Probleme {
    @Id
    @GeneratedValue
    private Long id;
    private String description;

    @Enumerated(EnumType.STRING)
    private Statut statut;

    private String cause;
    
    public Probleme() {
    }

    public enum Statut {
        OUVERT, EN_COURS, RESOLU, FERME
    }

    @OneToMany(mappedBy = "probleme")
    private List<Incident> incidents;


}
