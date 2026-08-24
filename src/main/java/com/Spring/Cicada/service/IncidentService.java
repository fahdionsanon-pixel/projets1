package com.Spring.Cicada.service;

import com.Spring.Cicada.model.Incident;
import com.Spring.Cicada.repository.IncidentRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class IncidentService {
    @Autowired
    private IncidentRepository IncidentRepository;

    public List<Incident> getAllIncidents() {
        return IncidentRepository.findAll();
    }
    public Incident createIncident(Incident incident) {
        return IncidentRepository.save(incident);
    }

    public void deleteIncident(Long id) {
        IncidentRepository.deleteById(id);
    }
    
}
