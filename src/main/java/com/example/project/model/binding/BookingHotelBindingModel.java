package com.example.project.model.binding;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDate;

public class BookingHotelBindingModel {
    private Integer countOfAdults;
    private Integer countOfChildren;
    private LocalDate startDate;
    private LocalDate endDate;
    @PositiveOrZero
    @NotNull
    public Integer getCountOfAdults() {
        return countOfAdults;
    }

    public void setCountOfAdults(Integer countOfAdults) {
        this.countOfAdults = countOfAdults;
    }
    @PositiveOrZero
    @NotNull
    public Integer getCountOfChildren() {
        return countOfChildren;
    }

    public void setCountOfChildren(Integer countOfChildren) {
        this.countOfChildren = countOfChildren;
    }
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Future
    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Future
    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
