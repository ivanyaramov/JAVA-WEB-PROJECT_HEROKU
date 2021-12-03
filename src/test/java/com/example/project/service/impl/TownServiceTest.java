package com.example.project.service.impl;

import com.example.project.model.entity.Hotel;
import com.example.project.model.entity.Town;
import com.example.project.repository.DayRepository;
import com.example.project.repository.HotelRepository;
import com.example.project.repository.TownRepository;
import com.example.project.service.CountryService;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    CountryService countryService;
    @Autowired
    TownService townService;
    @Autowired
    ModelMapper modelMapper;
    TownService townServiceToTest;
    @Mock
    TownRepository mockTownRepository;
    Town townToTest1;
    Town townToTest2;


    @BeforeEach
    void init() {
        dayRepository.deleteAll();
        hotelRepository.deleteAll();
        townServiceToTest = new TownServiceImpl(mockTownRepository, countryService, modelMapper);
        townToTest1 = new Town("town1", "aaa", "bbb");
        townToTest1.setId(1L);
        townToTest1.setCountry(countryService.findByName("England"));
        townToTest2 = new Town("town2", "bbb", "ggg");
        townToTest2.setId(2L);
        townToTest2.setCountry(countryService.findByName("Spain"));


    }

    @Test
    void testInitialiseTowns(){
        townRepository.deleteAll();
        townService.initialiseTowns();
        Assertions.assertEquals(29, townRepository.count());
    }

    @Test
    void testGetAllTownsAsStrings(){
        Mockito.when(mockTownRepository.findAll()).thenReturn(List.of(townToTest1, townToTest2));
        List<String> expected = new ArrayList<>();
        expected.add(  townToTest1.getName() + " (" +
        townToTest1.getCountry().getName() +
        ") id:" +
        townToTest1.getId());
        expected.add(  townToTest2.getName() + " (" +
                townToTest2.getCountry().getName() +
                ") id:" +
                townToTest2.getId());
        var actual = townServiceToTest.getAllTownsAsStrings();
        Assertions.assertEquals(expected.size(), actual.size());
      for(int i=0;i<actual.size();i++){
          Assertions.assertEquals(expected.get(i), actual.get(i));
      }

    }

}