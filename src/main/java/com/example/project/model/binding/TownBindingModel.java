package com.example.project.model.binding;

import com.example.project.model.entity.Country;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TownBindingModel {
    private String name;
    private String description;
    private String pictureUrl;
    private String country;
@NotNull
@Size(min = 1)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @NotNull
    @Size(min = 1)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @NotNull
    @Size(min = 1)
    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }
    @NotNull
    @Size(min = 1)
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
