package com.example.project.service;

import com.example.project.model.service.LandmarkServiceModel;

public interface LandmarkService {
    void initialiseLandmarks();

    void createLandmark(LandmarkServiceModel landmarkServiceModel);

}
