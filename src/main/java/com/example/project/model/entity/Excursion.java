package com.example.project.model.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;
@Entity
@Table(name = "excursions")
public class Excursion  extends BaseEntity{
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private Set<Country> countries;
    private Set<Town> towns;
    private Set<Hotel> hotels;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
@OneToMany
    public Set<Country> getCountries() {
        return countries;
    }

    public void setCountries(Set<Country> countries) {
        this.countries = countries;
    }
@OneToMany
    public Set<Town> getTowns() {
        return towns;
    }

    public void setTowns(Set<Town> towns) {
        this.towns = towns;
    }
@OneToMany
    public Set<Hotel> getHotels() {
        return hotels;
    }

    public void setHotels(Set<Hotel> hotels) {
        this.hotels = hotels;
    }
@Column
    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
@Column
    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
