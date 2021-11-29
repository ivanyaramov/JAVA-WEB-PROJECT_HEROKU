package com.example.project.model.binding;

import com.example.project.model.entity.StarsEnum;
import com.example.project.model.entity.Town;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class HotelBindingModel {
    private Long id;
    private String name;
    private Integer stars;
    private BigDecimal pricePerNightAdult;
    private BigDecimal pricePerNightChild;
    private String imageUrl;
    private String town;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotNull
@Size(min = 1)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
@NotNull
    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
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
    @Size(min = 1)
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    @NotNull
    @Size(min = 1)
    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }
}
