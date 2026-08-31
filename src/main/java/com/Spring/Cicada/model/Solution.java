package com.Spring.Cicada.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Entity
@Getter
@Setter

public class Solution {
    @Id
    @GeneratedValue
    private Long id;
    private String description;
    private String type;
    
    @Enumerated(EnumType.STRING)
    private Statut statut;

    public Solution() {
    }

    public enum Statut {
        PROPOSEE, APPROUVEE, REJETEE
    }

    @ManyToOne
    private Probleme probleme;

    @ManyToMany
    private List<ActifIT> actifs;
}
