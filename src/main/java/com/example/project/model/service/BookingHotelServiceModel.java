package com.example.project.model.service;

import java.time.LocalDate;

public class BookingHotelServiceModel {
    private Long id;
    private Integer countOfAdults;
    private Integer countOfChildren;
    private LocalDate startDate;
    private LocalDate endDate;
    private Long excursionId;
    private String username;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCountOfAdults() {
        return countOfAdults;
    }

    public void setCountOfAdults(Integer countOfAdults) {
        this.countOfAdults = countOfAdults;
    }

    public Integer getCountOfChildren() {
        return countOfChildren;
    }

    public void setCountOfChildren(Integer countOfChildren) {
        this.countOfChildren = countOfChildren;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Long getExcursionId() {
        return excursionId;
    }

    public void setExcursionId(Long excursionId) {
        this.excursionId = excursionId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
