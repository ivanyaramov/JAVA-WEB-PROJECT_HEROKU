package com.example.project.model.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "towns")
public class Town extends BaseEntity{
    private String name;
    private String description;
    private String pictureUrl;
    private Country country;
    private Set<Hotel> hotels;
    private Set<Landmark> landmarks;

    public Town() {
    }

    public Town(String name, String description, String pictureUrl) {
        this.name = name;
        this.description = description;
        this.pictureUrl = pictureUrl;
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
    @OneToMany(mappedBy = "town", fetch = FetchType.EAGER)
    public Set<Hotel> getHotels() {
        return hotels;
    }

    public void setHotels(Set<Hotel> hotels) {
        this.hotels = hotels;
    }
@OneToMany(mappedBy = "town", fetch = FetchType.EAGER)
    public Set<Landmark> getLandmarks() {
        return landmarks;
    }

    public void setLandmarks(Set<Landmark> landmarks) {
        this.landmarks = landmarks;
    }
@Column(columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
@Column
    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }
}
