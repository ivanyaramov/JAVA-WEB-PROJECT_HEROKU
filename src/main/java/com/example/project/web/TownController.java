package com.example.project.web;

import com.example.project.model.view.CountryViewModel;
import com.example.project.service.CountryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/towns")
public class TownController {
    private final CountryService countryService;

    public TownController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/all")
    public String viewAllTowns(Model model){
//        List<CountryViewModel> list = countryService.getAllCountries();
        model.addAttribute("countries",countryService.getAllCountries());
        return "town";
    }

}
