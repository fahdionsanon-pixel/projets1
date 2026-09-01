package com.Spring.Cicada.controller;

import com.Spring.Cicada.model.Probleme;
import com.Spring.Cicada.service.ProblemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProblemeWebController {

    @Autowired
    private ProblemeService problemeService;

    @GetMapping("/problemes")
    public String listeProblemes(Model model) {
        model.addAttribute("problemes", problemeService.getAllProblemes());
        return "liste-problemes";
    }

    @GetMapping("/problemes/nouveau")
    public String formulaireProbleme(Model model) {
        model.addAttribute("probleme", new Probleme());
        return "formulaire-probleme";
    }

    @PostMapping("/problemes/nouveau")
    public String creerProbleme(Probleme probleme) {
        problemeService.createProbleme(probleme);
        return "redirect:/problemes";
    }

    @PostMapping("/problemes/{id}/statut")
    public String changerStatut(@PathVariable Long id, @RequestParam Probleme.Statut statut) {
        problemeService.updateStatut(id, statut);
        return "redirect:/problemes";
    }

}