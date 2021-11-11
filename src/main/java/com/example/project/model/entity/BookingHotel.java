package com.example.project.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;
@Entity
@Table(name = "hotel_bookings")
public class BookingHotel extends BaseEntity{
    private UserEntity user;
    private Hotel hotel;
    private Integer countOfAdults;
    private Integer countOfChildren;
    private LocalDate startDate;
    private LocalDate endDate;
    @ManyToOne
    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
    @ManyToOne
    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
    @Column
    public Integer getCountOfAdults() {
        return countOfAdults;
    }

    public void setCountOfAdults(Integer countOfAdults) {
        this.countOfAdults = countOfAdults;
    }
    @Column
    public Integer getCountOfChildren() {
        return countOfChildren;
    }

    public void setCountOfChildren(Integer countOfChildren) {
        this.countOfChildren = countOfChildren;
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
