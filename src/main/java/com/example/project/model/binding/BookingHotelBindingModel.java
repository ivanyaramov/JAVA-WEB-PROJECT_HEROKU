package com.example.project.model.binding;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDate;

public class BookingHotelBindingModel {
    private Integer countOfAdults;
    private Integer countOfChildren;
    private LocalDate startDate;
    private int nights;
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
@Min(1)
@NotNull
    public int getNights() {
        return nights;
    }

    public void setNights(int nights) {
        this.nights = nights;
    }
}
