package com.example.project.service;

import com.example.project.model.entity.Guide;

public interface GuideService {
    void initaliseGuides();
    Guide findByFullName(String fullName);
}
