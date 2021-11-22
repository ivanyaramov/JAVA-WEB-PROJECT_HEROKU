package com.example.project.service;

import com.example.project.model.binding.DayBindingModel;
import com.example.project.model.entity.Day;
import com.example.project.model.entity.Hotel;
import com.example.project.model.entity.Town;
import com.example.project.model.service.DayServiceModel;
import com.example.project.model.view.DayViewModel;

import java.util.List;
import java.util.Set;

public interface DayService {
    void createDaysForExcursionInGermany();
    void createDaysForExcursionInItaly();
    void createDaysForExcursionInSpain();
    void saveDaysToDatabase(List<Day> days);
    List<DayViewModel> orderDays(Set<DayViewModel> set);
    Hotel getHotel(Town town);
    void initaliseDays();

    void createDay(Long id, DayServiceModel dayServiceModel);

    Day findById(Long id);

    void editDay(Long id, Long excursionid,  DayServiceModel dayServiceModel);

    DayBindingModel mapDayToBinding(Long id);
}
