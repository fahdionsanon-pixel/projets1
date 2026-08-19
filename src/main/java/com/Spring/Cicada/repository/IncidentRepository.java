package com.Spring.Cicada.repository;

import com.Spring.Cicada.model.Incident;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncidentRepository extends JpaRepository<Incident, Long> {
}