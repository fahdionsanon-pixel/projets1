package com.Spring.Cicada.controller;

import com.Spring.Cicada.model.ActifIT;
import com.Spring.Cicada.service.ActifITService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;


@Controller
@RequestMapping("/actifit")
public class ActifITWebController {
    @Autowired
    private ActifITService actifITService;

    @GetMapping("/nouveau")
    public String formulaireActifIT(Model model) {
        model.addAttribute("actifIT", new ActifIT());
        return "actifit/formulaire";
    }

    @PostMapping("/create")
    public String createActifIT(@ModelAttribute ActifIT actifIT) {
        actifITService.createActifIT(actifIT);
        return "redirect:/actifit/list";
    }

    @GetMapping("/list")
    public String listActifITs(Model model) {
        model.addAttribute("actifits", actifITService.getAllActifITs());
        return "actifit/list";
    }
    
}
