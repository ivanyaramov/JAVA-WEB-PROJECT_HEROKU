package com.example.project.web;

import com.example.project.model.entity.UserEntity;
import com.example.project.repository.TownRepository;
import com.example.project.repository.UserRepository;
import com.example.project.service.BookingExcursionService;
import com.example.project.service.ExcursionService;
import com.example.project.service.HotelService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;

import java.math.BigDecimal;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WithMockUser("lucho@example.com")
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

    private UserEntity testUser;

    @BeforeEach
    void setUp() {
        testUser = new UserEntity();
        testUser.setPassword("12345");
        testUser.setUsername("admin2");
        testUser.setEmail("lucho@example.com");
        testUser.setFullName("Ivan Yaramov");

        testUser = userRepository.save(testUser);
    }

    @AfterEach
    void tearDown() {
        userRepository.deleteAll();
    }

    @Test
    void testGetTowns() throws Exception {

        mockMvc.perform(get("/rest/townsandcountries")).
                andExpect(status().isOk()).
                andExpect(jsonPath("$", hasSize((int)townRepository.count()))).
                andExpect(jsonPath("$.[0]", is(townRepository.findById(1L).orElse(null).getName()+" ("+townRepository.findById(1L).orElse(null).getCountry().getName()+") id:1")));
//                andExpect(jsonPath("$.[1].message", is(COMMENT_2)));
    }

    @Test
    void testGetPriceOfExcursion() throws Exception {
        LinkedMultiValueMap<String, String> requestParams = new LinkedMultiValueMap<>();
        requestParams.add("countOfAdults", "1");
        requestParams.add("countOfChildren", "1");
        requestParams.add("id", "1");
        mockMvc.perform(post("/rest/bookingexcursionprice").params(requestParams)).
                andExpect(status().isOk()).
                andExpect(jsonPath("$", is(excursionService.priceOfExcursion(BigDecimal.ONE,BigDecimal.ONE,1L).doubleValue())));
//                andExpect(jsonPath("$.[1].message", is(COMMENT_2)));
    }

    @Test
    void testGetPriceOfHotelBooking() throws Exception {
        LinkedMultiValueMap<String, String> requestParams = new LinkedMultiValueMap<>();
        requestParams.add("countOfAdults", "1");
        requestParams.add("countOfChildren", "1");
        requestParams.add("id", "1");
        requestParams.add("startDate", "2023-11-29");
        requestParams.add("nights", "5");
        mockMvc.perform(post("/rest/bookinghotelprice").params(requestParams)).
                andExpect(status().isOk()).
                andExpect(jsonPath("$", is(hotelService.priceOfHotelBooking(1,BigDecimal.ONE,BigDecimal.ONE,1L).multiply(BigDecimal.valueOf(5)).doubleValue())));
//                andExpect(jsonPath("$.[1].message", is(COMMENT_2)));
    }

}
