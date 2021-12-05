package com.example.project.web;

import com.example.project.model.entity.Hotel;
import com.example.project.model.entity.UserEntity;
import com.example.project.repository.*;
import com.example.project.service.*;
import com.example.project.service.impl.HotelServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;

import java.math.BigDecimal;
import java.util.Optional;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WithMockUser("admin")
@SpringBootTest
@AutoConfigureMockMvc
public class RestConTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TownRepository townRepository;
    @Autowired
    private BookingExcursionService bookingExcursionService;
    @Autowired
    private ExcursionService excursionService;
    @Autowired
    private HotelService hotelService;
    @Autowired
    UserService userService;
    @Autowired
    HotelRepository hotelRepository;
    @Autowired
    TownService townService;
    @Autowired
    DayRepository dayRepository;
    @Mock
    HotelRepository mockHotelRepository;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    ExcursionRepository excursionRepository;

    private HotelService hotelServiceToTest;

    private UserEntity testUser;
    private Hotel testHotel;

    @BeforeEach
    void setUp() {
        dayRepository.deleteAll();
        hotelRepository.deleteAll();
        hotelServiceToTest = new HotelServiceImpl(townService, mockHotelRepository, modelMapper);
        hotelService.initialiseHotels();
        testUser = new UserEntity();
        testUser.setPassword("12345");
        testUser.setUsername("admin2");
        testUser.setEmail("lucho@example.com");
        testUser.setFullName("Ivan Yaramov");
        testHotel = new Hotel("testhotel", 5, BigDecimal.valueOf(15), BigDecimal.valueOf(20), townService.findByName("Sofia"), "aaa");
    }

    @AfterEach
    void tearDown() {
//        userRepository.deleteAll();
//        hotelRepository.deleteAll();
    }

    @Test
    void testGetTowns() throws Exception {
        mockMvc.perform(get("/rest/townsandcountries")).
                andExpect(status().isOk()).
                andExpect(jsonPath("$", hasSize((int)townRepository.count()))).
                andExpect(jsonPath("$.[0]", is(townRepository.findAll().stream().findFirst().orElse(null).getName()+" ("+townRepository.findAll().stream().findFirst().orElse(null).getCountry().getName()+") id:"+townRepository.findAll().stream().findFirst().orElse(null).getId() )));
//                andExpect(jsonPath("$.[1].message", is(COMMENT_2)));
    }

    @Test
    void testGetPriceOfExcursion() throws Exception {
//        userService.initaliseUsers();
        LinkedMultiValueMap<String, String> requestParams = new LinkedMultiValueMap<>();
        Long firstId = excursionRepository.findAll().stream().findFirst().get().getId();
        requestParams.add("countOfAdults", "1");
        requestParams.add("countOfChildren", "1");
        requestParams.add("id", firstId.toString());
        mockMvc.perform(post("/rest/bookingexcursionprice").params(requestParams)).
                andExpect(status().isOk()).
                andExpect(jsonPath("$", is(excursionService.priceOfExcursion(BigDecimal.ONE,BigDecimal.ONE,firstId).intValue())));
//                andExpect(jsonPath("$.[1].message", is(COMMENT_2)));
    }

    @Test
    void testGetPriceOfHotelBooking() throws Exception {
//        userService.initaliseUsers();
        Long firstId = hotelRepository.findAll().stream().findFirst().get().getId();
        hotelRepository.save(testHotel);
        LinkedMultiValueMap<String, String> requestParams = new LinkedMultiValueMap<>();
        requestParams.add("countOfAdults", "1");
        requestParams.add("countOfChildren", "1");
        requestParams.add("id", firstId.toString());
        requestParams.add("startDate", "2023-11-29");
        requestParams.add("nights", "5");
        mockMvc.perform(post("/rest/bookinghotelprice").params(requestParams)).
                andExpect(status().isOk()).
                andExpect(jsonPath("$", is(hotelService.priceOfHotelBooking(1,BigDecimal.ONE,BigDecimal.ONE,firstId).multiply(BigDecimal.valueOf(5)).doubleValue())));
//                andExpect(jsonPath("$.[1].message", is(COMMENT_2)));
    }

}
