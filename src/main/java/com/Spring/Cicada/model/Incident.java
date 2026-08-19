package com.Spring.Cicada.model;

import jakarta.persistence.*;
@Entity

public class Incident {
     @Id
     @GeneratedValue
     
    
        private Long id;
        private String titre;
        private String descriptions;
        private String statut;

        public Incident() {
        
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
        public String getDescriptions() {
            return descriptions;
        }
        public void setDescriptions(String descriptions) {
            this.descriptions = descriptions;
        }
        public String getStatut() {
            return statut;
        }
        public void setStatut(String statut) {
            this.statut = statut;
        }
        public void deleteIncident(){
            
        }




    
}