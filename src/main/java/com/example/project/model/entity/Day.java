package com.example.project.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;
@Entity
@Table(name = "days")
public class Day extends BaseEntity{
    private Integer numberOfDay;
    private String description;
    private Town town;
    private LocalDate date;
    private Excursion excursion;
    private Hotel hotel;

    public Day() {
    }

    public Day(Integer numberOfDay, Town town, Excursion excursion, Hotel hotel) {
        this.numberOfDay = numberOfDay;
        this.town = town;
        this.excursion = excursion;
        this.hotel = hotel;
    }

    @Column
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
@ManyToOne
    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }
    @ManyToOne
    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
@Column
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
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
