package org.endangered.miniproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class mainController {

    @GetMapping("/")
    @ResponseBody
    public String home() {
        return "Welcome to the Endangered Animal Tracker!";
    }
}
