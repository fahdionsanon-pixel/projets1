package com.Spring.Cicada.model;

import jakarta.persistence.*;

@Entity
public class ActifIT {
    @Id
    @GeneratedValue
    private Long id;
    private String nom;
    private String type;
    private String version;
    
    public ActifIT() {
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
