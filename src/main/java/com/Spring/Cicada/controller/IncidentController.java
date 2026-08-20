package com.Spring.Cicada.controller;

import com.Spring.Cicada.model.Incident;
import com.Spring.Cicada.service.IncidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/incidents")
public class IncidentController {

    @Autowired
    private IncidentService IncidentService;

    @GetMapping
    public List<Incident> getAllIncidents() {
        return IncidentService.getAllIncidents();
    }

    @PostMapping
    public Incident createIncident(@RequestBody Incident incident) {
        return IncidentService.createIncident(incident);
    }

    @PutMapping("/{id}")
    public Incident updateIncident(@PathVariable Long id, @RequestBody Incident incident) {
        incident.setId(id);
        return IncidentService.createIncident(incident);
    }

    @DeleteMapping("/{id}")
    public void deleteIncident(@PathVariable Long id) {
        IncidentService.deleteIncident(id);
    }
}