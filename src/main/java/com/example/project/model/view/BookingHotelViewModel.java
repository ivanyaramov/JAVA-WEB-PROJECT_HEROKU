package com.example.project.model.view;

import com.example.project.model.entity.Hotel;

import java.math.BigDecimal;
import java.time.LocalDate;

public class BookingHotelViewModel {
    private Long id;
    private String hotel;
    private String town;
    private Integer countOfAdults;
    private Integer countOfChildren;
    private LocalDate startDate;
    private Integer nights;
    private BigDecimal price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
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

    public Integer getNights() {
        return nights;
    }

    public void setNights(Integer nights) {
        this.nights = nights;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
