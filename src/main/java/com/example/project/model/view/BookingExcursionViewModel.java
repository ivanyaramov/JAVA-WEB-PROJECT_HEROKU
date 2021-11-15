package com.example.project.model.view;

import com.example.project.model.entity.Excursion;

import java.time.LocalDate;

public class BookingExcursionViewModel {
    private Long id;
    private String excursion;
    private Integer countOfAdults;
    private Integer countOfChildren;
    private LocalDate startDate;
    private LocalDate endDate;
    private Boolean isFinished;

    public Boolean getFinished() {
        return isFinished;
    }

    public void setFinished(Boolean finished) {
        isFinished = finished;
    }

    public String getExcursion() {
        return excursion;
    }

    public void setExcursion(String excursion) {
        this.excursion = excursion;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
