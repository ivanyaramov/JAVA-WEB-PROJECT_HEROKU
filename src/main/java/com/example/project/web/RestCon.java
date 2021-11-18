package com.example.project.web;

import com.example.project.service.CountryService;
import com.example.project.service.ExcursionService;
import com.example.project.service.HotelService;
import com.example.project.service.TownService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@RestController
public class RestCon {
    private final TownService townService;
    private final CountryService countryService;
    private final ExcursionService excursionService;
    private final HotelService hotelService;

    public RestCon(TownService townService, CountryService countryService, ExcursionService excursionService, HotelService hotelService) {
        this.townService = townService;
        this.countryService = countryService;
        this.excursionService = excursionService;
        this.hotelService = hotelService;
    }

    @GetMapping("/rest/townsandcountries")
    public List<String> townsAndCountries(){
        List<String> towns = new ArrayList<>();
               towns= townService.getAllTownsAsStrings();

        return towns;
    }

    @PostMapping ("/rest/bookingexcursionprice")
    public BigDecimal sumExcursion(@RequestParam BigDecimal countOfAdults,
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


        return excursionService.priceOfExcursion(countOfChildren, countOfAdults, id);

    }

    @PostMapping ("/rest/bookinghotelprice")
    public BigDecimal sumHotel(@RequestParam BigDecimal countOfAdults,
                          @RequestParam BigDecimal countOfChildren,
                          @RequestParam Long id,
                               @RequestParam String startDate,
                               @RequestParam  Integer nights){
        LocalDate startDate2 = LocalDate.parse(startDate);
        if (countOfAdults.compareTo(BigDecimal.valueOf(0))<0 || countOfChildren.compareTo(BigDecimal.valueOf(0))<0) {
            return BigDecimal.valueOf(-1);
        }else if(countOfAdults.add(countOfChildren).compareTo(BigDecimal.ZERO)==0){
            return BigDecimal.valueOf(-2);
        }
        else if(startDate2.compareTo(LocalDate.now())<0){
            return BigDecimal.valueOf(-3);
        }
        else if(nights<=0){
            return BigDecimal.valueOf(-4);
        }

        return hotelService.priceOfHotelBooking(nights, countOfChildren, countOfAdults, id);

    }
}
