package org.endangered.miniproject.controller;

import org.endangered.miniproject.model.EndangeredAnimals;
import org.endangered.miniproject.service.EndangeredAnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class EndangeredAnimalController {
    private final EndangeredAnimalService animalService;

    @Autowired
    public EndangeredAnimalController(EndangeredAnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping("/animals")
    public String getAllAnimals(Model model) {
        List<EndangeredAnimals> animals = animalService.getAllAnimals();
        model.addAttribute("animals", animals);
        return "endangeredAnimals"; // name of the Thymeleaf template
    }
}

