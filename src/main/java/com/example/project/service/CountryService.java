package com.example.project.service;

import com.example.project.model.entity.Country;

public interface CountryService {
    void initaliseCountries();
    Country findByName(String name);
}
