package com.example.project.service;

import com.example.project.model.entity.Guide;
import com.example.project.model.service.GuideServiceModel;

public interface GuideService {
    void initaliseGuides();
    Guide findByFullName(String fullName);

    void createGuide(GuideServiceModel guideServiceModel);

    GuideServiceModel findById(Long id);
    Guide findGuideById(Long id);

    void editGuide(Long id, GuideServiceModel guideServiceModel);
}
