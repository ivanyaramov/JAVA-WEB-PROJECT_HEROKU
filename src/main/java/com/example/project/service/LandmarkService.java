package com.example.project.service;

import com.example.project.model.entity.Landmark;
import com.example.project.model.service.LandmarkServiceModel;

public interface LandmarkService {
    void initialiseLandmarks();

    void createLandmark(LandmarkServiceModel landmarkServiceModel);

    Landmark findById(Long id);

    void editLandmark(Long id, LandmarkServiceModel landmarkServiceModel);

    Long getTownId(Long id);

    void deleteLandmark(Long id);
}
