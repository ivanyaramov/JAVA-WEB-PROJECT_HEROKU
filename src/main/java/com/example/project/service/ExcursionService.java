package com.example.project.service;

import com.example.project.model.entity.Excursion;
import com.example.project.model.view.ExcursionViewModel;

import java.math.BigDecimal;
import java.util.List;

public interface ExcursionService {
    void initaliseExcursions();
    Excursion findByName(String name);
    List<ExcursionViewModel> getAll();
    ExcursionViewModel getExcursionById(Long id);
    Excursion findById(Long id);
    Integer determinePlacesLeft(Excursion excursion);
    boolean hasEnoughPlaces(Long excursionId, Integer bookingSum);
    BigDecimal priceOfExcursion(BigDecimal children, BigDecimal adults, Long id);
}
