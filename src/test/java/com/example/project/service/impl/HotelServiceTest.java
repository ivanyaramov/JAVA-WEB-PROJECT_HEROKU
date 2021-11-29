package com.example.project.service.impl;

import com.example.project.model.entity.Hotel;
import com.example.project.model.entity.UserEntity;
import com.example.project.model.entity.UserRoleEntity;
import com.example.project.model.entity.UserRoleEnum;
import com.example.project.model.service.HotelServiceModel;
import com.example.project.repository.DayRepository;
import com.example.project.repository.HotelRepository;
import com.example.project.service.HotelService;
import com.example.project.service.TownService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class HotelServiceTest {
    private Hotel hotel1;
    private Hotel hotel2;
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
    HotelService hotelServiceToTest;
    @Mock
    HotelRepository mockHotelRepository;
    @BeforeEach
    void init() {
hotelService = new HotelServiceImpl(townService, hotelRepository, modelMapper);
hotelServiceToTest = new HotelServiceImpl(townService, mockHotelRepository, modelMapper);
   hotel1 = new Hotel();
hotel1.setTown(townService.findByName("Belgrade"));
hotel1.setId(1L);
hotel1.setStars(5);
hotel1.setName("hotel1");
hotel1.setPricePerNightAdult(BigDecimal.valueOf(15));
hotel1.setPricePerNightChild(BigDecimal.valueOf(15));
hotel1.setImageUrl("aaa");
        hotel2 = new Hotel();
        hotel2.setTown(townService.findByName("Sofia"));
        hotel2.setId(2L);
        hotel2.setStars(3);
        hotel2.setName("hotel2");
        hotel2.setPricePerNightAdult(BigDecimal.valueOf(30));
        hotel2.setPricePerNightChild(BigDecimal.valueOf(30));
        hotel2.setImageUrl("bbb");
    }

    @Test
    void initialiseHotels(){
        dayRepository.deleteAll();
        hotelRepository.deleteAll();
        hotelService.initialiseHotels();
        Assertions.assertEquals(54, hotelRepository.count());
    }

    @Test
    void editHotel(){
        HotelServiceModel hotelServiceModel = modelMapper.map(hotel1, HotelServiceModel.class);
        hotelServiceModel.setName("testname");
        hotelServiceModel.setImageUrl("fff");
        Mockito.when(mockHotelRepository.findById(hotel1.getId())).thenReturn(Optional.of(hotel1));
        hotelServiceToTest.editHotel(1L, hotelServiceModel );

        var actual = hotelServiceToTest.findById(1L);
        Assertions.assertEquals(hotelServiceModel.getName(), actual.getName());
        Assertions.assertEquals(hotelServiceModel.getImageUrl(), actual.getImageUrl());
    }

}
