package com.example.project.model.view;

import com.example.project.model.entity.Country;
import com.example.project.model.entity.Hotel;
import com.example.project.model.entity.Landmark;

import java.util.Set;

public class TownViewModel {
    private Long id;
    private String name;
    private String description;
    private String pictureUrl;
    private CountryViewModel countryViewModel;
    private Set<LandmarkViewModel> landmarks;
    private Set<HotelViewModel> hotels;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<LandmarkViewModel> getLandmarks() {
        return landmarks;
    }

    public void setLandmarks(Set<LandmarkViewModel> landmarks) {
        this.landmarks = landmarks;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public CountryViewModel getCountryViewModel() {
        return countryViewModel;
    }

    public void setCountryViewModel(CountryViewModel countryViewModel) {
        this.countryViewModel = countryViewModel;
    }

    public Set<HotelViewModel> getHotels() {
        return hotels;
    }

    public void setHotels(Set<HotelViewModel> hotels) {
        this.hotels = hotels;
    }
}
