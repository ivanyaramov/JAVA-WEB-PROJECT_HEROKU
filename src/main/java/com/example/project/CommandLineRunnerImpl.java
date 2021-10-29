package com.example.project;

import com.example.project.service.CountryService;
import com.example.project.service.TownService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommandLineRunnerImpl implements CommandLineRunner {
    private final CountryService countryService;
    private final TownService townService;

    public CommandLineRunnerImpl(CountryService countryService, TownService townService) {
        this.countryService = countryService;
        this.townService = townService;
    }

    @Override
    public void run(String... args) throws Exception {
        countryService.initaliseCountries();
        townService.initialiseTowns();
    }
}
