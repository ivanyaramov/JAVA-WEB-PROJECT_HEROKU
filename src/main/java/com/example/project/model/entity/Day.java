package com.example.project.model.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "days")
public class Day extends BaseEntity{
    private Integer numberOfDay;
    private String description;
    private Set<Town> towns;

    private Excursion excursion;
    private Hotel hotel;

    public Day() {
    }

    public Day(Integer numberOfDay, Set<Town> towns, Excursion excursion, Hotel hotel) {
        this.numberOfDay = numberOfDay;
        this.towns = towns;
        this.excursion = excursion;
        this.hotel = hotel;
    }

    @Column(columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
@ManyToMany(fetch = FetchType.EAGER)
    public Set<Town> getTowns() {
        return towns;
    }

    public void setTowns(Set<Town> towns) {
        this.towns = towns;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

@ManyToOne
    public Excursion getExcursion() {
        return excursion;
    }

    public void setExcursion(Excursion excursion) {
        this.excursion = excursion;
    }
@Column(nullable = false)
    public Integer getNumberOfDay() {
        return numberOfDay;
    }

    public void setNumberOfDay(Integer numberOfDay) {
        this.numberOfDay = numberOfDay;
    }
}
