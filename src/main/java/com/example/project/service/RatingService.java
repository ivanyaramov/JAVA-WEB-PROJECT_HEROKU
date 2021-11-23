package com.example.project.service;

import com.example.project.model.binding.RatingBindingModel;

public interface RatingService {
    void createRating(String username, Long excursionid, RatingBindingModel ratingBindingModel);

}
