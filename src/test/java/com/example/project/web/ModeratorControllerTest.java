package com.example.project.web;

import com.example.project.model.entity.*;
import com.example.project.repository.DayRepository;
import com.example.project.repository.HotelRepository;
import com.example.project.service.HotelService;
import com.example.project.service.TownService;
import com.example.project.service.impl.HotelServiceImpl;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Set;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
@WithMockUser("admin2")
@SpringBootTest
@AutoConfigureMockMvc
public class ModeratorControllerTest {

    private UserEntity testUser;
    private UserEntity testUser2;
    private UserRoleEntity adminRole, moderatorRole, userRole;
@Autowired
private HotelService hotelService;


    @Autowired
    TownService townService;
    @Autowired
    DayRepository dayRepository;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    HotelRepository hotelRepository;

    @Autowired
MockMvc mockMvc;

    @Autowired
    private HotelService mockHotelService;


    private final String HOTEL_NAME = "justaname";
    private final String TOWN = "Sofia";
    private final String STARS = StarsEnum.S3.toString();
    private final String PRICE_PER_NIGHT_ADULT = "10";
    private final String PRICE_PER_NIGHT_CHILD = "10";
    private final String IMAGE_URL = "image";

    @Autowired
    private WebApplicationContext webApplicationContext;



    @BeforeEach
    void init() {
        dayRepository.deleteAll();
        hotelRepository.deleteAll();
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        //ARRANGE
        hotelService = new HotelServiceImpl(townService, hotelRepository, modelMapper);


        adminRole = new UserRoleEntity();
        adminRole.setRole(UserRoleEnum.ADMIN);
        moderatorRole = new UserRoleEntity();
        moderatorRole.setRole(UserRoleEnum.MODERATOR);
        userRole = new UserRoleEntity();
        userRole.setRole(UserRoleEnum.USER);



        testUser = new UserEntity();
        testUser.setUsername("admin2");
        testUser.setEmail("asaff!@gmal.com");
        testUser.setPassword("12345");
        testUser.setRoles(Set.of(adminRole, userRole, moderatorRole));
        testUser2 = new UserEntity();
        testUser2.setUsername("admin3");
        testUser2.setEmail("asaff!@gmal.comd");
        testUser2.setPassword("12345");
        testUser2.setRoles(Set.of(userRole, moderatorRole));
//        mockUserRepository.save(testUser2);
//        mockUserRepository.save(testUser);
    }
    @AfterEach
    void tearDown() { hotelRepository.deleteAll();
    }
    @Test
    void testAddHotel() throws Exception{
        Long initial = hotelRepository.count();
        mockMvc.perform(post("/add/hotel").
                param("id","100").
                param("name",HOTEL_NAME).
                param("town", TOWN).
                param("stars","2").
                param("pricePerNightAdult",PRICE_PER_NIGHT_ADULT).
                param("pricePerNightChild", PRICE_PER_NIGHT_CHILD).
                param("imageUrl",IMAGE_URL).
                with(csrf()).
                contentType(MediaType.APPLICATION_FORM_URLENCODED));

        Assertions.assertEquals(initial + 1, hotelRepository.count());

        Optional<Hotel> newlyCreatedHotel = hotelRepository.findByName(HOTEL_NAME);

        Assertions.assertTrue(newlyCreatedHotel.isPresent());
        Hotel hotel = newlyCreatedHotel.get();
        Long id = hotel.getId();

        Assertions.assertEquals(HOTEL_NAME, hotel.getName());
        Assertions.assertEquals(PRICE_PER_NIGHT_CHILD, String.format("%.0f",hotel.getPricePerNightChild()));
        Assertions.assertEquals(PRICE_PER_NIGHT_ADULT, String.format("%.0f",hotel.getPricePerNightAdult()));
        Assertions.assertEquals(IMAGE_URL, hotel.getImageUrl());

    }
}
