package com.example.project.model.binding;

import com.example.project.model.entity.RatingEnum;

import javax.validation.constraints.NotNull;

public class RatingBindingModel {
    Integer rating;
    @NotNull
    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
}
