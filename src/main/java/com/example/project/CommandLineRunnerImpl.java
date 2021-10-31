package com.example.project;

import com.example.project.service.CountryService;
import com.example.project.service.HotelService;
import com.example.project.service.TownService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommandLineRunnerImpl implements CommandLineRunner {
    private final CountryService countryService;
    private final TownService townService;
    private final HotelService hotelService;

    public CommandLineRunnerImpl(CountryService countryService, TownService townService, HotelService hotelService) {
        this.countryService = countryService;
        this.townService = townService;
        this.hotelService = hotelService;
    }

    @Override
    public void run(String... args) throws Exception {
        init();
    }

    void init(){
        countryService.initaliseCountries();
        townService.initialiseTowns();
        hotelService.initialiseHotels();

    }
}
