package com.example.project.web;

import com.example.project.model.entity.Town;
import com.example.project.model.view.TownViewModel;
import com.example.project.service.CountryService;
import com.example.project.service.TownService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/towns")
public class TownController {
    private final CountryService countryService;
    private final TownService townService;

    public TownController(CountryService countryService, TownService townService) {
        this.countryService = countryService;
        this.townService = townService;
    }

    @GetMapping("/all")
    public String viewAllTowns(Model model){
//        List<CountryViewModel> list = countryService.getAllCountries();
        model.addAttribute("countries",countryService.getAllCountries());
        return "town";
    }

    @GetMapping("/landmarks/{id}")
    public String landmarksOfTown(@PathVariable Long id, Model model){
    model.addAttribute("town", townService.findById(id));
    return "town-landmarks";
    }

    @GetMapping("/hotels/{id}")
    public String hotelsOfTown(@PathVariable Long id, Model model){
        TownViewModel town = townService.findById(id);
        model.addAttribute("town", town);
        return "town-hotels";
    }

    @GetMapping("/landmarks/forhelp/{name}")
    public String helpMethodToRedirect(@PathVariable String name){
        System.out.println(name);
        String townAsString = name.split(" ")[0];
        Town town = townService.findByName(townAsString);
        System.out.println(town.getName());
        Long id = town.getId();
        return "redirect:/towns/landmarks/" + id;

    }


}
