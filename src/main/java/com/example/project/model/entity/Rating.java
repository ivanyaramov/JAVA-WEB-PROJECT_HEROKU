package com.example.project.model.entity;

import com.fasterxml.jackson.databind.ser.Serializers;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ratings")
public class Rating extends BaseEntity {
    private Double rating;
    private Excursion excursion;
    private User user;
    @Column
    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

@ManyToOne
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
@ManyToOne
    public Excursion getExcursion() {
        return excursion;
    }

    public void setExcursion(Excursion excursion) {
        this.excursion = excursion;
    }
}
