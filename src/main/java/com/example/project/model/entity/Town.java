package com.example.project.model.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "towns")
public class Town extends BaseEntity{
    private String name;
    private Country country;
    private Set<Hotel> hotels;
    private Set<Landmark> landmarks;

    public Town() {
    }

    public Town(String name) {
        this.name = name;
    }

    @Column(nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
@ManyToOne
    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
    @OneToMany(mappedBy = "town")
    public Set<Hotel> getHotels() {
        return hotels;
    }

    public void setHotels(Set<Hotel> hotels) {
        this.hotels = hotels;
    }
@OneToMany(mappedBy = "town")
    public Set<Landmark> getLandmarks() {
        return landmarks;
    }

    public void setLandmarks(Set<Landmark> landmarks) {
        this.landmarks = landmarks;
    }
}
