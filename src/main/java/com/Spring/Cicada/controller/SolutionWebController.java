package com.Spring.Cicada.controller;

import com.Spring.Cicada.model.Solution;
import com.Spring.Cicada.service.SolutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SolutionWebController {

    @Autowired
    private SolutionService solutionService;

    @GetMapping("/solutions")
    public String listeSolutions(Model model) {
        model.addAttribute("solutions", solutionService.getAllSolutions());
        return "liste-solutions";
    }

    @GetMapping("/solutions/nouveau")
    public String formulaireSolution(Model model) {
        model.addAttribute("solution", new Solution());
        return "formulaire-solution";
    }

    @PostMapping("/solutions/nouveau")
    public String creerSolution(Solution solution) {
        solutionService.createSolution(solution);
        return "redirect:/solutions";
    }
}