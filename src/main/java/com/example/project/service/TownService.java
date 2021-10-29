package com.example.project.service;

import com.example.project.model.entity.Town;

public interface TownService {
    void initialiseTowns();
    Town findByName(String name);
}
