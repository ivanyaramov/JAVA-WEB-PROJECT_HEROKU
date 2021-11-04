package com.example.project.service;

import com.example.project.model.entity.Day;

import java.util.List;

public interface DayService {
    List<Day> createDaysForExcursionInGermany();
    List<Day> createDaysForExcursionInItaly();
    List<Day> createDaysForExcursionInSpain();
    void saveDaysToDatabase(List<Day> days);
}
