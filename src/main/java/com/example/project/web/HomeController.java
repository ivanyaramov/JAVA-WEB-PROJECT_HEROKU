package com.example.project.web;

import com.example.project.service.CountryService;
import com.example.project.service.ExcursionService;
import com.example.project.service.TownService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class HomeController {
private final TownService townService;
private final CountryService countryService;
private final ExcursionService excursionService;

    public HomeController(TownService townService, CountryService countryService, ExcursionService excursionService) {
        this.townService = townService;
        this.countryService = countryService;
        this.excursionService = excursionService;
    }


    @GetMapping("/")
    public String home(Model model, Principal principal){
        model.addAttribute("towns",townService.getAllTowns());
        model.addAttribute("excursions", excursionService.getFirst3());
        return "index";
    }

}
