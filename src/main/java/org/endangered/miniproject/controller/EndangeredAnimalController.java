package org.endangered.miniproject.controller;

import org.endangered.miniproject.model.Cords;
import org.endangered.miniproject.model.EndangeredAnimals;
import org.endangered.miniproject.service.CordsService;
import org.endangered.miniproject.service.EndangeredAnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class EndangeredAnimalController {

    private final EndangeredAnimalService animalService;

    @Autowired
    private CordsService cordsService;  // Service to fetch Cords

    @Autowired
    public EndangeredAnimalController(EndangeredAnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping("/animals")
    public String getAllAnimals(Model model) {
        try {
            List<EndangeredAnimals> animals = animalService.getAllAnimals();
            model.addAttribute("animals", animals);
            return "endangeredAnimals"; // Thymeleaf template name
        } catch (Exception e) {
            model.addAttribute("error", "An error occurred while fetching animal data.");
            return "error";
        }
    }


    @GetMapping("/detail/{id}")
    public String getAnimalDetails(@PathVariable String id, Model model) {
        try {
            EndangeredAnimals animal = animalService.getAnimalById(id);
            if (animal == null) {
                model.addAttribute("error", "Animal not found");
                return "error";
            }
            List<Cords> cordsList = cordsService.getCordsByAnimalId(animal.getId());
            model.addAttribute("animal", animal);
            model.addAttribute("cordsList", cordsList);
            return "animal_detail";
        } catch (Exception e) {
            model.addAttribute("error", "An error occurred while fetching animal details.");
            return "error";
        }
    }
}
