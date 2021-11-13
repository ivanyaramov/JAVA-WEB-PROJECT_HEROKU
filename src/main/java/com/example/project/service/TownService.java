package com.example.project.service;

import com.example.project.model.entity.Town;
import com.example.project.model.view.LandmarkViewModel;
import com.example.project.model.view.TownViewModel;

import java.util.List;
import java.util.Set;

public interface TownService {
    void initialiseTowns();
    Town findByName(String name);
    TownViewModel findById(Long id);
    List<String> getAllTownsAsStrings();
    List<String> getOnlyTownsAsStrings();
    List<TownViewModel> getAllTowns();
    List<Town> getAllTownsAsNormal();
}
