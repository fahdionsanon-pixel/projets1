package com.Spring.Cicada.controller;

import com.Spring.Cicada.model.Incident;
import com.Spring.Cicada.service.IncidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IncidentWebController {

    @Autowired
    private IncidentService incidentService;

    @GetMapping("/incidents")
    public String listeIncidents(Model model) {
        model.addAttribute("incidents", incidentService.getAllIncidents());
        return "liste-incidents";
    }

    @GetMapping("/incidents/creation-formulaire")
    public String formulaireIncident(Model model) {
        model.addAttribute("incident", new Incident());
        return "formulaire-incident";
    }

    @PostMapping("/incidents/creation-formulaire")
    public String creerIncident(Incident incident) {
        incidentService.createIncident(incident);
        return "redirect:/incidents";
    }

    @PostMapping("/incidents/{id}/statut")
    public String changerStatut(@PathVariable Long id, @RequestParam Incident.Statut statut) {
        incidentService.updateStatut(id, statut);
        return "redirect:/incidents";
    }

}