package com.example.project.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "ratings")
public class Rating extends BaseEntity {
    private Integer rating;
    private BookingExcursion bookingExcursion;
    private UserEntity user;
@Column
    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @ManyToOne
    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
@OneToOne

    public BookingExcursion getBookingExcursion() {
        return bookingExcursion;
    }

    public void setBookingExcursion(BookingExcursion bookingExcursion) {
        this.bookingExcursion = bookingExcursion;
    }
}
