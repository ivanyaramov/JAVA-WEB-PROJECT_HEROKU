package com.example.project.service.impl;

import com.example.project.model.entity.Guide;
import com.example.project.repository.GuideRepository;
import com.example.project.service.GuideService;
import org.springframework.stereotype.Service;

@Service
public class GuideServiceImpl implements GuideService {
    private final GuideRepository guideRepository;

    public GuideServiceImpl(GuideRepository guideRepository) {
        this.guideRepository = guideRepository;
    }

    @Override
    public void initaliseGuides() {
        if (guideRepository.count()==0){
            Guide anton = new Guide("Anton Biserov", 47);
            anton.setDescription("Hello, my name is Anton Biserov. I have been a guide in this company for 3 years. I have many years of experience in the field, as I have been doing this for 15 years in total. I speak 4 languages perfectly - Italian, Bulgarian, English and German. Travel and history have always been my passion, and sharing it with people makes me really happy. I will be happy to immerse ourselves together in the culture and history of countries and create memories for a lifetime.");

        }
    }
}
