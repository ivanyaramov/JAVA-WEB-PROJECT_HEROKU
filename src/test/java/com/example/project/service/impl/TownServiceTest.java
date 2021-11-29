package com.example.project.service.impl;

import com.example.project.model.entity.Hotel;
import com.example.project.repository.DayRepository;
import com.example.project.repository.HotelRepository;
import com.example.project.repository.TownRepository;
import com.example.project.service.HotelService;
import com.example.project.service.TownService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TownServiceTest {


    @Autowired
    TownRepository townRepository;
    @Autowired
    HotelRepository hotelRepository;
    @Autowired
    DayRepository dayRepository;

    @Autowired
    TownService townService;
    @Autowired
    ModelMapper modelMapper;


    @BeforeEach
    void init() {
        dayRepository.deleteAll();
        hotelRepository.deleteAll();

    }

    @Test
    void testInitialiseTowns(){
        townRepository.deleteAll();
        townService.initialiseTowns();
        Assertions.assertEquals(29, townRepository.count());
    }

}