package com.example.project.service.impl;

import com.example.project.model.entity.Excursion;
import com.example.project.model.entity.Guide;
import com.example.project.model.entity.UserEntity;
import com.example.project.model.service.GuideServiceModel;
import com.example.project.repository.DayRepository;
import com.example.project.repository.ExcursionRepository;
import com.example.project.repository.GuideRepository;
import com.example.project.service.GuideService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GuideServiceTest {

    @Autowired
    ExcursionRepository excursionRepository;
    @Autowired
    GuideRepository guideRepository;
    @Autowired
    GuideService guideService;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    DayRepository dayRepository;
    GuideService guideServiceToTest;
    @Mock
    GuideRepository mockGuideRepository;
    private final int AGE =88;
    private final String DESCRIPTION = "aaa";
    private final String PictureURL= "pic";
    private final String FULLNAME = "FullName";

    @Test
    void initialiseHotels(){
        guideServiceToTest = new GuideServiceImpl(mockGuideRepository, modelMapper);
        dayRepository.deleteAll();
        excursionRepository.deleteAll();
        guideRepository.deleteAll();
        guideService.initaliseGuides();
        Assertions.assertEquals(3, guideRepository.count());
    }

    @Test
    void editGuide(){
        GuideServiceModel guideServiceModel=  new GuideServiceModel();
        guideServiceModel.setAge(AGE);
        guideServiceModel.setDescription(DESCRIPTION);
        guideServiceModel.setPictureUrl(PictureURL);
        guideServiceModel.setFullName(FULLNAME);
        Long firstId = guideRepository.findAll().stream().findFirst().get().getId();
        guideService.editGuide(firstId,guideServiceModel);
        var actual = guideRepository.findByFullName(FULLNAME);
        Guide guide = actual.get();
        Assertions.assertEquals(AGE, guide.getAge());
        Assertions.assertEquals(FULLNAME, guide.getFullName());
        Assertions.assertEquals(DESCRIPTION, guide.getDescription());
        Assertions.assertEquals(PictureURL, guide.getPictureUrl());
    }
}
