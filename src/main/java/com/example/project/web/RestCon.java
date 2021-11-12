package com.example.project.web;

import com.example.project.service.CountryService;
import com.example.project.service.ExcursionService;
import com.example.project.service.TownService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
@RestController
public class RestCon {
    private final TownService townService;
    private final CountryService countryService;
    private final ExcursionService excursionService;

    public RestCon(TownService townService, CountryService countryService, ExcursionService excursionService) {
        this.townService = townService;
        this.countryService = countryService;
        this.excursionService = excursionService;
    }

    @GetMapping("/rest/townsandcountries")
    public List<String> townsAndCountries(){
        List<String> towns = new ArrayList<>();
               towns= townService.getAllTownsAsStrings();

        return towns;
    }

    @PostMapping ("/rest/bookingexcursionprice")
    public BigDecimal sum(@RequestParam BigDecimal countOfAdults,
                       @RequestParam BigDecimal countOfChildren,
                          @RequestParam Long id){

        if (countOfAdults.compareTo(BigDecimal.valueOf(0))<0 || countOfChildren.compareTo(BigDecimal.valueOf(0))<0) {
            return BigDecimal.valueOf(-1);
        }else if(countOfAdults.add(countOfChildren).compareTo(BigDecimal.ZERO)==0){
            return BigDecimal.valueOf(-2);
        }
        Integer placesLeft = excursionService.determinePlacesLeft(excursionService.findById(id));
        BigDecimal sum = countOfAdults.add(countOfChildren);
        if(sum.compareTo(BigDecimal.valueOf(placesLeft))>0){
            return BigDecimal.valueOf(-3);
        }

        return countOfAdults.add(countOfChildren);

    }
}
