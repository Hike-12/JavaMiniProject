package org.endangered.miniproject.controller;

import org.endangered.miniproject.model.Cords;
import org.endangered.miniproject.model.EndangeredAnimals;
import org.endangered.miniproject.service.CordsService;
import org.endangered.miniproject.service.EndangeredAnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class EndangeredAnimalController {

    private final EndangeredAnimalService animalService;

    @Autowired
    private CordsService cordsService;  // Service to fetch Cords

    @Autowired
    public EndangeredAnimalController(EndangeredAnimalService animalService) {
        this.animalService = animalService;
    }

    // Get all endangered animals
    @GetMapping("/animals")
    public String getAllAnimals(Model model) {
        List<EndangeredAnimals> animals = animalService.getAllAnimals();
        model.addAttribute("animals", animals);
        return "endangeredAnimals"; // Thymeleaf template name
    }

    // Get details for a specific animal, including its associated cords
    @GetMapping("/detail/{id}")
    public String getAnimalDetails(@PathVariable String id, Model model) {
        // Fetch the animal details by ID
        EndangeredAnimals animal = animalService.getAnimalById(id);

        // Fetch the associated Cords by animal ID (a list)
        List<Cords> cordsList = cordsService.getCordsByAnimalId(animal.getId());

        // Add both animal and cords to the model
        model.addAttribute("animal", animal);
        model.addAttribute("cordsList", cordsList);  // Use a list of cords here
        System.out.println(cordsList);

        // Return the name of the template to render
        return "animal_detail";
    }
}
