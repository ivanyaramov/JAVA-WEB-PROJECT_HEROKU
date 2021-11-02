package com.example.project.web;

import com.example.project.service.CountryService;
import com.example.project.service.TownService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
@RestController
public class RestCon {
    private final TownService townService;
    private final CountryService countryService;

    public RestCon(TownService townService, CountryService countryService) {
        this.townService = townService;
        this.countryService = countryService;
    }

    @GetMapping("/rest/townsandcountries")
    public List<String> townsAndCountries(){
        List<String> towns = new ArrayList<>();
               towns= townService.getAllTownsAsStrings();

        return towns;
    }
}
