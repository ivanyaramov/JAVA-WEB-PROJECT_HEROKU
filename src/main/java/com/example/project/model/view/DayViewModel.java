package com.example.project.model.view;

import com.example.project.model.entity.Excursion;
import com.example.project.model.entity.Hotel;
import com.example.project.model.entity.Town;

import java.util.Set;

public class DayViewModel {
    private Long id;
    private Integer numberOfDay;
    private String description;
    private Set<TownViewModel> towns;
    private Hotel hotel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumberOfDay() {
        return numberOfDay;
    }

    public void setNumberOfDay(Integer numberOfDay) {
        this.numberOfDay = numberOfDay;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Set<TownViewModel> getTowns() {
        return towns;
    }

    public void setTowns(Set<TownViewModel> towns) {
        this.towns = towns;
    }
}
