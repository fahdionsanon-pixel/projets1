package com.Spring.Cicada.service;

import com.Spring.Cicada.model.Incident;
import com.Spring.Cicada.repository.IncidentRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class IncidentService {
    @Autowired
    private IncidentRepository incidentRepository;

    public List<Incident> getAllIncidents() {
        return incidentRepository.findAll();
    }

    public Incident createIncident(Incident incident) {
        return incidentRepository.save(incident);
    }

    public void deleteIncident(Long id) {
        incidentRepository.deleteById(id);
    }

    public Incident updateStatut(Long id, Incident.Statut nouveauStatut) {
        Incident incident = incidentRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Incident introuvable : " + id));
        incident.setStatut(nouveauStatut);
        return incidentRepository.save(incident);
    }
}