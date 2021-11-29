package com.example.project.service.impl;

import com.example.project.repository.DayRepository;
import com.example.project.repository.HotelRepository;
import com.example.project.service.HotelService;
import com.example.project.service.TownService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class HotelServiceTest {
    @Autowired
    DayRepository dayRepository;
    @Autowired
    HotelService hotelService;
    @Autowired
    HotelRepository hotelRepository;
    @Autowired
    TownService townService;
    @Autowired
    ModelMapper modelMapper;
    @BeforeEach
    void init() {
hotelService = new HotelServiceImpl(townService, hotelRepository, null);
    }

    @Test
    void initialiseHotels(){
        dayRepository.deleteAll();
        hotelRepository.deleteAll();
        hotelService.initialiseHotels();
        Assertions.assertEquals(54, hotelRepository.count());
    }

}
