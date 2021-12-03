package com.example.project.service.impl;

import com.example.project.model.binding.DayBindingModel;
import com.example.project.model.comparator.DayComparator;
import com.example.project.model.entity.Day;
import com.example.project.model.entity.Excursion;
import com.example.project.model.entity.Hotel;
import com.example.project.model.entity.Town;
import com.example.project.model.service.DayServiceModel;
import com.example.project.model.view.DayViewModel;
import com.example.project.repository.DayRepository;
import com.example.project.service.DayService;
import com.example.project.service.ExcursionService;
import com.example.project.service.TownService;
import com.example.project.web.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DayServiceImpl implements DayService {
    private final DayRepository dayRepository;
    private final TownService townService;
    private final ExcursionService excursionService;
    private final ModelMapper modelMapper;

    public DayServiceImpl(DayRepository dayRepository, TownService townService, ExcursionService excursionService, ModelMapper modelMapper) {
        this.dayRepository = dayRepository;
        this.townService = townService;
        this.excursionService = excursionService;
        this.modelMapper = modelMapper;
    }


    @Override
    public void createDaysForExcursionInGermany() {
        List<Day> list = new ArrayList<>();
        Town sofia = townService.findByName("Sofia");
        Town belgrade = townService.findByName("Belgrade");
        Town budapest = townService.findByName("Budapest");
        Town vienna = townService.findByName("Vienna");
        Town innsbruck = townService.findByName("Innsbruck");
        Town munich = townService.findByName("Munich");
        Town frankfurt = townService.findByName("Frankfurt");
        Town stuttgart = townService.findByName("Stuttgart");
        Town rust = townService.findByName("Rust");
        Town strasbourg = townService.findByName("Strasbourg");
        Excursion inGeramny = excursionService.findByName("Excursion in Germany");
        Day day1 = new Day(1, Set.of(sofia), inGeramny, getHotel(belgrade));
        day1.setDescription("At the first day we will meet near the University Of Sofia at 8:00 on 15.06.2022. We will have 3 spare hours" +
                "so we will visit some of Sofia's main landmarks like the Aleksandar Nevski's Cathedral and the palace of culture. At 11 we get onto the bus" +
                "and we head to Belgrade. We will be there at about 6pm and have dinner and rest.");
        Day day2 = new Day(2, Set.of(belgrade, budapest), inGeramny, getHotel(budapest));
        day2.setDescription("On day 2 we will meet at the hotel hall at 8:30. We will go round Belgrade with the bus and do sightseeing with the tour guide talking interesting stories without " +
                "leaving the bus. At about 10:00 we will leave Belgrade and head towards Budapest. We will be there at about 1:30. You will have the oppurtunity to see the famous Hungarian parliament" +
                "that is alongside the Danube river and even get inside it. Afterwards we will check out Castle Var andat about 20:00 we will head towards our hotel in budapest.");

        Day day3 = new Day(3, Set.of(vienna), inGeramny, getHotel(innsbruck));
        day3.setDescription("On day 3 we get up at 6:30 and then get in the bus and head towards Vienna. When we arrive you will have 3 free hours to freeroam it" +
                "and afterwards we will go round some of the most famous landmarks of the city - Prater and Schonburg palace. At about 19:00 we will head towards" +
                "Innsbruck where our hotel for the night is.");
        Day day4 = new Day(4, Set.of(innsbruck, munich), inGeramny, getHotel(munich));
        day4.setDescription("On day 4 we will get up at 7:00 and the bus will leave us at the Ambras castle and after we are done with it" +
                " you will have a couple of hours free time in the city. After that we will head towards Munichwhere we will visit the Alianz arena and " +
                "the BMW museum. We will spend the rest of our day there and head to the hotel.");
        Day day5 = new Day(5, Set.of(frankfurt, stuttgart), inGeramny, getHotel(stuttgart));
        day5.setDescription("On day 5 we will get up at 7:00 and our first destination will be the famous Stuttagrt Zoo. " +
                "Afterwards we will visit the Mercedes museum where a guide will describe the history of the company. " +
                "You will have 4 hours to spend at the museum (there are many interactial things to do). " +
                "We will spend the night at a hotel in Stuttgart.");
        Day day6 = new Day(6, Set.of(rust), inGeramny, getHotel(stuttgart));
        day6.setDescription("This is the funniest day of the whole excursion. We will visit the Europa park, where we will " +
                "spend the whole day. It is famous for the highest rollercoaster in Europe. The ones who don't want to " +
                "visit the park will spend the day in Strasbourg and visit the Notre Dame Cathedral and afterwards you will have some free time in the city. " +
                "In the evening we will go back to our hotel in Stuttgart.");
        Day day7 = new Day(7, Set.of(vienna), inGeramny, getHotel(vienna));
        day7.setDescription("On day 7 we will cover all the way back to Vienna. We will spend the night there.");
        Day day8 = new Day(8, Set.of(belgrade), inGeramny, getHotel(belgrade));
        day8.setDescription("We get up at 8:00 and the bus will head towards Belgrade. Due to the long distance we will not have " +
                "the oppurtunity to do anything else. We will reach Belgrade at 20:00.");
        Day day9 = new Day(9, null, inGeramny, null);
        day9.setDescription("The last day of the excursion! We will head towards Sofia after we get up at 8:00. " +
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
        saveDaysToDatabase(list);
    }

    @Override
    public void createDaysForExcursionInItaly() {

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



    @Override
    public void createDaysForExcursionInSpain() {
        List<Day> list = new ArrayList<>();
        Town porto = townService.findByName("Porto");
        Town sofia = townService.findByName("Sofia");
        Town lisabon = townService.findByName("Lisbon");
        Town madrid = townService.findByName("Madrid");
        Town barcelona = townService.findByName("Barcelona");
        Town andorra = townService.findByName("Andorra la Vella");
        Town seville = townService.findByName("Seville");
        Town lyon = townService.findByName("Lyon");
        Town paris = townService.findByName("Paris");
        Excursion inSpain = excursionService.findByName("Excursion in Spain");
        Day day1 = new Day(1, Set.of(sofia), inSpain, getHotel(lisabon));
        day1.setDescription("At the first day we will meet at the Sofia airport at 1t 15:00 Our flight takes off " +
                "at 17:30. We will arrive in Lisabon at 20:00 and then immediately go to our hotel with the bus.");
        Day day2 = new Day(2, Set.of(lisabon), inSpain, getHotel(porto));
        day2.setDescription("On day 2 we will wake up at  7:30. We will first visit Castelo de S. Jorge which is a great historic sight " +
                "in the capital of Portugal. Then we will visit Praca do Comercio and you'll have free time for about 3 hours. " +
                "After that we'll go to the hotel.");
        Day day3 = new Day(3, Set.of(porto), inSpain, getHotel(madrid));
        day3.setDescription("On day 3 we will get up at 6:00. Then we will visit Luis do Bridge and have lunch at the best burgers in " +
                "Portugal. The bus will leave you at the main square of the city and you'll have 1.30 hours to do some shopping. " +
                "You'll get picked up at the same place and then we'll have a long journey to Madrid. There we'll go directly to our hotel.");
        Day day4 = new Day(4, Set.of(madrid), inSpain, getHotel(seville));
        day4.setDescription("On day 4 we will get up at 7:00. The first thing we will be doing is that we visit the " +
                "great Santiagu Bernabeu stadium of Real Madrid. Then we will visit the Temple of Deboud and after we are done with it " +
                "we will head towards Seville. We will be there by midnight.");
        Day day5 = new Day(5, Set.of(seville), inSpain, getHotel(barcelona));
        day5.setDescription("On day 5 we will get up at 7:00. Then we will go to Plaza de Espana and a few other landmarks. After " +
                "we go round the city we will head towards Barcelona.");
        Day day6 = new Day(6, Set.of(barcelona),inSpain, getHotel(andorra));
        day6.setDescription("On day 6 we get up at 7:30. We will first visit the Camp nou stadium of Barcelona. Then " +
                "we will get in the famous Cathedral and afterwards you will be able to go wherever you want. " +
                "At about 6:00 we will meet up at the bus and head towards Andorra.");
        Day day7 = new Day(7, Set.of(andorra), inSpain, getHotel(andorra));
        day7.setDescription("We will spend the whole day 7 in the small country of Andorra! We will climb the mountain to see the " +
                "picturesque view from the top. The ones who don't want to climb the mountain will have free time in the capital city.");
        Day day8 = new Day(8, Set.of(lyon), inSpain, getHotel(lyon));
        day8.setDescription("This is the last day before our departure. We will drive from Andorra to Lyon. At Lyon we will " +
                "visit the Bellecour and some other landmarks. We will go to our hotel at late evening.");
        Day day9 = new Day(9, null, inSpain, null);
        day9.setDescription("We take our flight from Lyon to Sofia at 10:30. We will be at sofia at about 12:30.");
        list.add(day1);
        list.add(day2);
        list.add(day3);
        list.add(day4);
        list.add(day5);
        list.add(day6);
        list.add(day7);
        list.add(day8);
        list.add(day9);
        saveDaysToDatabase(list);

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

    @Override
    public void initaliseDays() {
        if(dayRepository.count()==0){
            createDaysForExcursionInItaly();
            createDaysForExcursionInGermany();
            createDaysForExcursionInSpain();

        }
    }

    @Override
    public void createDay(Long id, DayServiceModel dayServiceModel) {
dayServiceModel.setId(null);
        Day day = modelMapper.map(dayServiceModel, Day.class);
        Set<Town> set = new HashSet<>();
        day.setHotel(getHotel(townService.findByName(dayServiceModel.getSleep())));
        set.add(townService.findByName(dayServiceModel.getTown1()));
        if(!dayServiceModel.getTown2().equals("")) {
            set.add(townService.findByName(dayServiceModel.getTown2()));
        }
        if(!dayServiceModel.getTown3().equals("")) {
            set.add(townService.findByName(dayServiceModel.getTown3()));
        }
        day.setTowns(set);
        day.setExcursion(excursionService.findById(id));


        Excursion excursion = excursionService.findById(id);
        Set<DayViewModel> setOfViewModel= excursion.getDays().stream().map(d-> modelMapper.map(d, DayViewModel.class)).collect(Collectors.toSet());
        List<DayViewModel> list = orderDays(setOfViewModel);
        boolean incrementDays = false;
        for(DayViewModel d: list){
            if(d.getNumberOfDay().equals(day.getNumberOfDay())){
                incrementDays = true;
                break;
            }
        }
        if(incrementDays){
            for(DayViewModel d: list){
                if(d.getNumberOfDay().compareTo(day.getNumberOfDay()) >=0){
                    Day current = findById(d.getId());
                    current.setNumberOfDay(current.getNumberOfDay()+1);
                    dayRepository.save(current);
                }
            }
        }
        dayRepository.save(day);
        excursionService.addDay(id, day);
    }

    @Override
    public Day findById(Long id) {
        return dayRepository.findById(id).orElseThrow(()-> new ObjectNotFoundException(id,"days"));
    }

    @Override
    public void throwExceptionIfDayNotFound(Long id){
        findById(id);
    }

    @Override
    public void editDay(Long id, Long excursionid, DayServiceModel dayServiceModel) {
        throwExceptionIfDayNotFound(id);
        Day day = modelMapper.map(dayServiceModel, Day.class);
        day.setDescription(dayServiceModel.getDescription());
        if(!dayServiceModel.getSleep().equals("")) {
            day.setHotel(getHotel(townService.findByName(dayServiceModel.getSleep())));
        }
        Set<Town> set = new HashSet<>();
        set.add(townService.findByName(dayServiceModel.getTown1()));
        if(!dayServiceModel.getTown2().equals("")) {
            set.add(townService.findByName(dayServiceModel.getTown2()));
        }
        if(!dayServiceModel.getTown3().equals("")) {
            set.add(townService.findByName(dayServiceModel.getTown3()));
        }
        day.setTowns(set);
        day.setExcursion(excursionService.findById(excursionid));
        dayRepository.save(day);
    }

    @Override
    public void deleteDay(Long id) {
        Day day = findById(id);
        Excursion excursion = excursionService.findById(day.getExcursion().getId());
        Set<DayViewModel> setOfViewModel= excursion.getDays().stream().map(d-> modelMapper.map(d, DayViewModel.class)).collect(Collectors.toSet());
        List<DayViewModel> list = orderDays(setOfViewModel);
        for(DayViewModel d: list){
            if(d.getNumberOfDay().compareTo(day.getNumberOfDay()) >=0){
                Day current = findById(d.getId());
                current.setNumberOfDay(current.getNumberOfDay()-1);
                dayRepository.save(current);
            }
        }

        dayRepository.deleteById(id);

    }

    @Override
    public DayBindingModel mapDayToBinding(Long id) {
       Day day = findById(id);
       Set<Town> set = day.getTowns();
       List<Town> list = new ArrayList<>();
       list.addAll(set);
       DayBindingModel dayBindingModel = modelMapper.map(day, DayBindingModel.class);
       for(int i=0;i<list.size();i++){
           if(i==0){
               dayBindingModel.setTown1(list.get(i).getName());
           }
           if(i==1){
               dayBindingModel.setTown2(list.get(i).getName());
           }
           if(i==2){
               dayBindingModel.setTown3(list.get(i).getName());
           }
       }
       if(day.getHotel() !=null) {
           dayBindingModel.setSleep(day.getHotel().getTown().getName());
       }
return dayBindingModel;
    }


}
