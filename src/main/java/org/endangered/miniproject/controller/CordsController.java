package org.endangered.miniproject.controller;

import org.endangered.miniproject.model.Cords;
import org.endangered.miniproject.service.CordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CordsController {

    private final CordsService cordsService;

    @Autowired
    public CordsController(CordsService cordsService) {
        this.cordsService = cordsService;
    }

    @GetMapping("/coordinates")
    public String getAllCords(Model model) {
        List<Cords> cordsList = cordsService.getAllCords();
        model.addAttribute("cords", cordsList);
        System.out.println(cordsList);
        return "coordinates"; // name of the Thymeleaf template for displaying coordinates
    }
}
