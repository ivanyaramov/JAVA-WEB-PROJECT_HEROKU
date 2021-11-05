package com.example.project;

import com.example.project.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommandLineRunnerImpl implements CommandLineRunner {
    private final CountryService countryService;
    private final TownService townService;
    private final HotelService hotelService;
    private final LandmarkService landmarkService;
    private final GuideService guideService;
    private final ExcursionService excursionService;
    private final DayService dayService;

    public CommandLineRunnerImpl(CountryService countryService, TownService townService, HotelService hotelService, LandmarkService landmarkService, GuideService guideService, ExcursionService excursionService, DayService dayService) {
        this.countryService = countryService;
        this.townService = townService;
        this.hotelService = hotelService;
        this.landmarkService = landmarkService;
        this.guideService = guideService;
        this.excursionService = excursionService;
        this.dayService = dayService;
    }

    @Override
    public void run(String... args) throws Exception {
        init();
    }

    public void init(){
        countryService.initaliseCountries();
        townService.initialiseTowns();
        hotelService.initialiseHotels();
        guideService.initaliseGuides();
        landmarkService.initialiseLandmarks();
        excursionService.initaliseExcursions();
        dayService.createDaysForExcursionInItaly();

    }
}
