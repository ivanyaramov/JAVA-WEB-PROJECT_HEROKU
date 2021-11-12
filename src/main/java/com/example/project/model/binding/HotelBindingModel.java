package com.example.project.model.binding;

import com.example.project.model.entity.StarsEnum;
import com.example.project.model.entity.Town;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

public class HotelBindingModel {
    private String name;
    private StarsEnum stars;
    private BigDecimal pricePerNightAdult;
    private BigDecimal pricePerNightChild;
    private String imageUrl;
    private String town;
@NotNull
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @NotNull
    public StarsEnum getStars() {
        return stars;
    }

    public void setStars(StarsEnum stars) {
        this.stars = stars;
    }
    @Positive
    @NotNull
    public BigDecimal getPricePerNightAdult() {
        return pricePerNightAdult;
    }

    public void setPricePerNightAdult(BigDecimal pricePerNightAdult) {
        this.pricePerNightAdult = pricePerNightAdult;
    }
    @NotNull
    @Positive
    public BigDecimal getPricePerNightChild() {
        return pricePerNightChild;
    }

    public void setPricePerNightChild(BigDecimal pricePerNightChild) {
        this.pricePerNightChild = pricePerNightChild;
    }
    @NotNull
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    @NotNull
    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }
}
