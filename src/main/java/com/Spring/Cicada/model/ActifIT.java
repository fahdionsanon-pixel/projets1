package com.Spring.Cicada.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Entity
@Getter
@Setter
public class ActifIT {

    @Id
    @GeneratedValue
    private Long id;
    private String nom;
    private String type;
    private String version;

    public ActifIT() {
    }

    @ManyToMany(mappedBy = "actifs")
    private List<Solution> solutions;
}