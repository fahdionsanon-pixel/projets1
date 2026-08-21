package com.Spring.Cicada.repository;

import com.Spring.Cicada.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    
}
