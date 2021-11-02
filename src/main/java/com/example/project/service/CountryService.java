package com.example.project.service;

import com.example.project.model.entity.Country;
import com.example.project.model.view.CountryViewModel;

import java.util.List;

public interface CountryService {
    void initaliseCountries();
    Country findByName(String name);
    List<CountryViewModel> getAllCountries();
}
