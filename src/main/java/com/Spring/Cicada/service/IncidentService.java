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
    public Incident getIncidentById(Long id) {
        return incidentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Incident introuvable : " + id));
    }

    public Incident updateIncident(Long id, Incident incidentModifie) {
        Incident incident = getIncidentById(id);
        incident.setTitre(incidentModifie.getTitre());
        incident.setDescription(incidentModifie.getDescription());
        incident.setPriorite(incidentModifie.getPriorite());
        incident.setProbleme(incidentModifie.getProbleme());
        incident.setActifsConcernes(incidentModifie.getActifsConcernes());
        return incidentRepository.save(incident);
    }

}