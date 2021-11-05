package com.example.project.service.impl;

import com.example.project.model.comparator.DayComparator;
import com.example.project.model.entity.Day;
import com.example.project.model.entity.Excursion;
import com.example.project.model.entity.Hotel;
import com.example.project.model.entity.Town;
import com.example.project.model.view.DayViewModel;
import com.example.project.repository.DayRepository;
import com.example.project.service.DayService;
import com.example.project.service.ExcursionService;
import com.example.project.service.TownService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class DayServiceImpl implements DayService {
    private final DayRepository dayRepository;
    private final TownService townService;
    private final ExcursionService excursionService;

    public DayServiceImpl(DayRepository dayRepository, TownService townService, ExcursionService excursionService) {
        this.dayRepository = dayRepository;
        this.townService = townService;
        this.excursionService = excursionService;
    }


    @Override
    public void createDaysForExcursionInGermany() {
        List<Day> list = new ArrayList<>();

    }

    @Override
    public void createDaysForExcursionInItaly() {
        if (dayRepository.count() == 0) {
            List<Day> list = new ArrayList<>();
            Town sofia = townService.findByName("Sofia");
            Town belgrade = townService.findByName("Belgrade");
            Town dubrovnik = townService.findByName("Dubrovnik");
            Town zagreb = townService.findByName("Zagreb");
            Town milano = townService.findByName("Milano");
            Town florentia = townService.findByName("Florentia");
            Town ljubljana = townService.findByName("Ljubljana");
            Town rome = townService.findByName("Rome");
            Town vatican = townService.findByName("Vatican");
            Town sanmarino = townService.findByName("San Marino");
            Excursion inItaly = excursionService.findByName("Excursion in Italy");
            Day day1 = new Day(1, Set.of(sofia), inItaly, getHotel(belgrade));
            day1.setDescription("At the first day we will meet near the University Of Sofia at 8:00 on 15.06.2022. We will have 3 spare hours" +
                    "so we will visit some of Sofia's main landmarks like the Aleksandar Nevski's Cathedral and the palace of culture. At 11 we get onto the bus" +
                    "and we head to Belgrade. We will be there at about 6pm and have dinner and rest.");
            Day day2 = new Day(2, Set.of(belgrade, dubrovnik), inItaly, getHotel(zagreb));
            day2.setDescription("On day 2 we will meet at the hotel hall at 8:30. We will go round Belgrade with the bus and do sightseeing with the tour guide talking interesting stories without " +
                    "leaving the bus. At about 10:00 we will leave Belgrade and head towards Dubrovnik. We will be there at about 1:30. You will have the oppurtunity to see the town from above by going on " +
                    "the Cable car for only 30 euros per person. Afterwards you will see the famous sight where part of the Game Of Thrones scenes were filmed." +
                    "After that you will have some spare time at the old town of Dubrovnik (Stradun). We will meet up in front of the bus at 18:30 and head towards Zagreb.");

            Day day3 = new Day(3, Set.of(zagreb), inItaly, getHotel(milano));
            day3.setDescription("On day 3 we get up at 8:30 again and by 9:30 we will be at the centre of the city. The tour guide will take " +
                    "you around some of the landmarks there and at about 12:00 you will have free time to room around the city and have lunch." +
                    "At 4:00 we meet up in front of the bus and we head towards Milano where our hotel is.");

            Day day4 = new Day(4, Set.of(milano), inItaly, getHotel(florentia));
            day4.setDescription("On day 4 we get up at 7:30 because we have a lot to see! If the majority of the group wants we can start off" +
                    "by visiting the mighty San Siro, the stadium of Milan and Inter. Afterwards we will visit the most famous landmarks of the city" +
                    "like Duomo di Milano and the museum of art Galleria Vittorio Emanuele II. We will spent the rest of our day there" +
                    "At about 17:30 we will get into the bus and head towards Florentia.");

            Day day5 = new Day(5, Set.of(florentia, sanmarino), inItaly, getHotel(rome));
            day5.setDescription("On day 5 We get up at 6:30. Then the bus will leave us at the center of the city of Florence. " +
                    "The tour guide will introduce us some of the most famous landmarks - Basilica of Santa Croce and Uffizi Gallery." +
                    "We will afterwards go to the shopping center of Florence and you will have free time for about 1:30 hours. We meet up " +
                    "in the bus at 12:00. Then we head to the picturesque country of San Marino. It is one of the smallest countries in the world." +
                    " We will visit the Gualita tower and afterwards you may have lunch at one of the best pizzarias in the whole world!" +
                    "We will go round the whole country with the bus (it is not much) and after that head towards Rome. We be there at 22:00.");

            Day day6 = new Day(6, Set.of(rome, vatican), inItaly, getHotel(rome));
            day6.setDescription("On Day 6 we wake up in Rome at 6:30. We then head towards the listed landmarks. After that we will " +
                    "get into the smallest country in the world - Vatican. We will wait for a while in front of the gates until the authorities " +
                    "invite us. The population of this country is mainly from priests. We will visit the museums and see very interesting sights like Michaelangelo's paintings. " +
                    "After we are done there we will head back to our hotel in Rome.");

            Day day7 = new Day(7, Set.of(rome), inItaly, getHotel(rome));
            day7.setDescription("On day 7 we get up at 8:00 and the bus will leave you at the center of the city. This day is totally free " +
                    "and you can do whatever you want. We meet up at 18:00 on the same spot the bus has left you and we head back to the hotel.");

            Day day8 = new Day(8, Set.of(ljubljana), inItaly, getHotel(ljubljana));
            day8.setDescription("On day 8 we get up at 8:00 and head towards the capital of Slovenia - Ljubljana. After we arrive there at about noon we will do some " +
                    "sightseeing around the Ljubljana castle and the Dragon Bridge. Then you will have 2 hours spare time and at 19:00 we will head to our hotel there");

            Day day9 = new Day(9, Set.of(belgrade), inItaly, getHotel(belgrade));
            day9.setDescription("We get up at 8:00 and the bus will head towards Belgrade. Due to the long distance we will not have " +
                    "the oppurtunity to do anything else. We will reach Belgrade at 20:00.");

            Day day10 = new Day(10, null, inItaly, null);
            day10.setDescription("The last day of the excursion! We will head towards Sofia after we get up at 8:00. " +
                    "We will arrive at 16:00 at the place where the excursion started. Hopefully you will have had great time!");
            list.add(day1);
            list.add(day2);
            list.add(day3);
            list.add(day4);
            list.add(day5);
            list.add(day6);
            list.add(day7);
            list.add(day8);
            list.add(day9);
            list.add(day10);
            saveDaysToDatabase(list);
        }
    }

    @Override
    public void createDaysForExcursionInSpain() {
        List<Day> list = new ArrayList<>();
    }

    @Override
    public void saveDaysToDatabase(List<Day> days) {
for(Day day: days){
    dayRepository.save(day);
}
    }

    @Override
    public List<DayViewModel> orderDays(Set<DayViewModel> set) {
        List<DayViewModel> list = new ArrayList<>();
        list.addAll(set);
        Collections.sort(list,new DayComparator());
        return list;
    }

    @Override
    public Hotel getHotel(Town town) {
        return town.getHotels().iterator().next();
    }


}
