package com.example.project.service;

import com.example.project.model.entity.Day;
import com.example.project.model.entity.Excursion;
import com.example.project.model.service.ExcursionServiceModel;
import com.example.project.model.view.ExcursionViewModel;

import java.math.BigDecimal;
import java.util.List;

public interface ExcursionService {
    void initaliseExcursions();
    Excursion findByName(String name);
    List<ExcursionViewModel> getAll();
    List<ExcursionViewModel> getFirst3();
    ExcursionViewModel getExcursionById(Long id);
    Excursion findById(Long id);
    Integer determinePlacesLeft(Excursion excursion);
    boolean hasEnoughPlaces(Long excursionId, Integer bookingSum);
    BigDecimal priceOfExcursion(BigDecimal children, BigDecimal adults, Long id);
    Double getAverageRating(Long id);

    boolean hasExcursionStarted(Long id);

    void createExcursion(ExcursionServiceModel excursionServiceModel);

    void editExcursion(Long id, ExcursionServiceModel excursionServiceModel);

    void addDay(Long id, Day day);
    void throwExceptionIfExcursionDoesNotExist(Long id);
}
