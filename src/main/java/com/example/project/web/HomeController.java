package com.example.project.web;

import com.example.project.service.CountryService;
import com.example.project.service.TownService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
private final TownService townService;
private final CountryService countryService;

    public HomeController(TownService townService, CountryService countryService) {
        this.townService = townService;
        this.countryService = countryService;
    }


    @GetMapping("/")
    public String home(Model model){
        return "index";
    }

}
