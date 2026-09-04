package com.Spring.Cicada.controller;

import com.Spring.Cicada.model.Utilisateur;
import com.Spring.Cicada.service.UtilisateurService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UtilisateurWebController {

    @Autowired
    private UtilisateurService utilisateurService;

    @GetMapping("/utilisateurs/nouveau")
    public String formulaireUtilisateur(Model model) {
        model.addAttribute("utilisateur", new Utilisateur());
        return "formulaire-utilisateur";
    }

    @PostMapping("/utilisateurs/nouveau")
    public String creerUtilisateur(@Valid Utilisateur utilisateur, BindingResult result) {
        if (result.hasErrors()) {
            return "formulaire-utilisateur";
        }
        utilisateurService.createUtilisateur(utilisateur);
        return "redirect:/login";
    }
}