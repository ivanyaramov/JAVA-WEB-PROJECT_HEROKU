package com.example.project.service.impl;

import com.example.project.model.entity.Day;
import com.example.project.model.entity.Town;
import com.example.project.repository.DayRepository;
import com.example.project.service.DayService;
import com.example.project.service.TownService;

import java.util.ArrayList;
import java.util.List;

public class DayServiceImpl implements DayService {
    private final DayRepository dayRepository;
    private final TownService townService;

    public DayServiceImpl(DayRepository dayRepository, TownService townService) {
        this.dayRepository = dayRepository;
        this.townService = townService;
    }


    @Override
    public List<Day> createDaysForExcursionInGermany() {
        List<Day> list = new ArrayList<>();

        return list;
    }

    @Override
    public List<Day> createDaysForExcursionInItaly() {
        List<Day> list = new ArrayList<>();
        Town sofia = townService.findByName("Sofia");
        Town belgrade = townService.findByName("Belgrade");
        Town dubrovnik = townService.findByName("Dubrovnik");
        Town zagreb = townService.findByName("Zagreb");
        Town milano = townService.findByName("Milano");
        Day day1 = new Day();
        return list;
    }

    @Override
    public List<Day> createDaysForExcursionInSpain() {
        List<Day> list = new ArrayList<>();
        return list;
    }

    @Override
    public void saveDaysToDatabase(List<Day> days) {
for(Day day: days){
    dayRepository.save(day);
}
    }
}
