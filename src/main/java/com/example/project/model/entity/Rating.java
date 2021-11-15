package com.example.project.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "ratings")
public class Rating extends BaseEntity {
    private RatingEnum rating;
    private BookingExcursion excursion;
    private UserEntity user;
@Enumerated(EnumType.STRING)
    public RatingEnum getRating() {
        return rating;
    }

    public void setRating(RatingEnum rating) {
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

    public BookingExcursion getExcursion() {
        return excursion;
    }

    public void setExcursion(BookingExcursion excursion) {
        this.excursion = excursion;
    }
}
