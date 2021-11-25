package com.example.project.service;

import com.example.project.model.entity.Guide;
import com.example.project.model.service.GuideServiceModel;

import java.util.List;

public interface GuideService {
    void initaliseGuides();
    Guide findByFullName(String fullName);

    void createGuide(GuideServiceModel guideServiceModel);

    GuideServiceModel findById(Long id);
    Guide findGuideById(Long id);
    void throwExceptionIfGuideNotFound(Long id);
    void editGuide(Long id, GuideServiceModel guideServiceModel);

    List<String> getAllGuides();
}
