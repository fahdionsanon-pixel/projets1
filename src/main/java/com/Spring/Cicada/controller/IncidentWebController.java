package com.Spring.Cicada.controller;

import com.Spring.Cicada.model.Incident;
import com.Spring.Cicada.service.ActifITService;
import com.Spring.Cicada.service.IncidentService;
import com.Spring.Cicada.service.ProblemeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;


@Controller
public class IncidentWebController {

    @Autowired
    private IncidentService incidentService;

    @Autowired
    private ProblemeService problemeService;

    @Autowired
    private ActifITService actifITService;

    @GetMapping("/incidents/creation-formulaire")
    public String formulaireIncident(Model model) {
        model.addAttribute("incident", new Incident());
        model.addAttribute("problemes", problemeService.getAllProblemes());
        model.addAttribute("actifs", actifITService.getAllActifITs());
        return "formulaire-incident";
    }


    @GetMapping("/incidents")
    public String listeIncidents(Model model) {
        model.addAttribute("incidents", incidentService.getAllIncidents());
        return "liste-incidents";
    }

    @PostMapping("/incidents/creation-formulaire")
    public String creerIncident(@Valid Incident incident, BindingResult result) {
        if (result.hasErrors()) {
            return "formulaire-incident";
        }
        incidentService.createIncident(incident);
        return "redirect:/incidents";
    }

    @PostMapping("/incidents/{id}/statut")
    public String changerStatut(@PathVariable Long id, @RequestParam Incident.Statut statut) {
        incidentService.updateStatut(id, statut);
        return "redirect:/incidents";
    }

    @GetMapping("/incidents/{id}/modifier")
    public String formulaireModification(@PathVariable Long id, Model model) {
        model.addAttribute("incident", incidentService.getIncidentById(id));
        model.addAttribute("problemes", problemeService.getAllProblemes());
        model.addAttribute("actifs", actifITService.getAllActifITs());
        return "formulaire-incident-modifier";
    }

    @PostMapping("/incidents/{id}/modifier")
    public String modifierIncident(@PathVariable Long id, @Valid Incident incident, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("problemes", problemeService.getAllProblemes());
            model.addAttribute("actifs", actifITService.getAllActifITs());
            return "formulaire-incident-modifier";
        }
        incidentService.updateIncident(id, incident);
        return "redirect:/incidents";
    }

}