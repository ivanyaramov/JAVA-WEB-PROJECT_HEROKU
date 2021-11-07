package com.example.project;

import com.example.project.model.entity.UserRoleEntity;
import com.example.project.model.entity.UserRoleEnum;
import com.example.project.repository.UserRoleRepository;
import com.example.project.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CommandLineRunnerImpl implements CommandLineRunner {
    private final CountryService countryService;
    private final TownService townService;
    private final HotelService hotelService;
    private final LandmarkService landmarkService;
    private final GuideService guideService;
    private final ExcursionService excursionService;
    private final DayService dayService;
    private final UserRoleRepository userRoleRepository;

    public CommandLineRunnerImpl(CountryService countryService, TownService townService, HotelService hotelService, LandmarkService landmarkService, GuideService guideService, ExcursionService excursionService, DayService dayService, UserRoleRepository userRoleRepository) {
        this.countryService = countryService;
        this.townService = townService;
        this.hotelService = hotelService;
        this.landmarkService = landmarkService;
        this.guideService = guideService;
        this.excursionService = excursionService;
        this.dayService = dayService;
        this.userRoleRepository = userRoleRepository;
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
        initializeRoles();

    }

    private void initializeRoles() {
//long count = userRoleRepository.count();
        if (userRoleRepository.count() == 0) {
            UserRoleEntity adminRole = new UserRoleEntity();
            adminRole.setRole(UserRoleEnum.ADMIN);

            UserRoleEntity userRole = new UserRoleEntity();
            userRole.setRole(UserRoleEnum.USER);
            UserRoleEntity moderatorRole = new UserRoleEntity();
            moderatorRole.setRole(UserRoleEnum.MODERATOR);

            userRoleRepository.saveAll(List.of(adminRole, userRole, moderatorRole));
        }
    }
}
