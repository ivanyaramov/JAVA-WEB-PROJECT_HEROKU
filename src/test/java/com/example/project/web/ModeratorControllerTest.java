package com.example.project.web;

import com.example.project.model.entity.*;
import com.example.project.repository.*;
import com.example.project.service.GuideService;
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
import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

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
    Excursion excursionToTest;
    @Autowired
    GuideService guideService;
    @Autowired
    ExcursionRepository excursionRepository;
    @Autowired
    LandmarkRepository landmarkRepository;
    @Autowired
    TownRepository townRepository;
    @Autowired
    GuideRepository guideRepository;

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
    private final String startDate = "2006-05-15";
    private final String endDate = "2006-08-23";
    private final String guide = "Anton Biserov";
    private final String DESCRIPTION = "aaa";


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


        excursionToTest = new Excursion("excursiontotest", LocalDate.of(2009, 5 , 6), LocalDate.of(2015, 5 , 6), 50);
        excursionToTest.setId(1L);
        excursionToTest.setPictureUrl("aaa");
        Long guideFirstId = guideRepository.findAll().stream().findFirst().get().getId();
        excursionToTest.setGuide(modelMapper.map(guideService.findById(guideFirstId), Guide.class));
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
    void tearDown() {
        hotelRepository.deleteAll();
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

    @Test
    void testEditExcursion() throws Exception {
        Long initial = excursionRepository.count();
        Long firstId = excursionRepository.findAll().stream().findFirst().get().getId();
        mockMvc.perform(post("/edit/excursion/" + firstId).
                param("name","Edited Excursion").
                param("startDate",startDate).
                param("endDate", endDate).
                param("capacity","100").
                param("pictureUrl",IMAGE_URL).
                param("guide",guide).
                with(csrf()).
                contentType(MediaType.APPLICATION_FORM_URLENCODED));

        Assertions.assertEquals(initial, excursionRepository.count());

        Optional<Excursion> editedExcursion = excursionRepository.findById(firstId);

        Assertions.assertTrue(editedExcursion.isPresent());
        Excursion excursion = editedExcursion.get();

        Assertions.assertEquals("Edited Excursion", excursion.getName());
        Assertions.assertEquals(100, excursion.getCapacity());
        Assertions.assertEquals(guide, excursion.getGuide().getFullName());
        Assertions.assertEquals(IMAGE_URL, excursion.getPictureUrl());
    }

    @Test
    void editExcursionFail() throws Exception {
        Long firstId = excursionRepository.findAll().stream().findFirst().get().getId();
        mockMvc.perform(post("/edit/excursion/"+ firstId).
                param("name","").
                param("startDate",startDate).
                param("endDate", endDate).
                param("capacity","100").
                param("pictureUrl",IMAGE_URL).
                param("guide",guide)).andExpect(redirectedUrl("/edit/excursion/"+ firstId));

    }
    @Test
    void getEditExcursion() throws Exception {
        Long firstId = excursionRepository.findAll().stream().findFirst().get().getId();
        mockMvc.
                perform(get("/edit/excursion/" + firstId))
                .andExpect(status().isOk())
                .andExpect(view().name("excursion-edit"));
    }

    @Test
    void testObjectNotFound() throws Exception {
        mockMvc.
                perform(get("/edit/excursion/100000"))
                .andExpect(status().isOk())
                .andExpect(view().name("object-not-found"));
    }


    @Test
    void getEditLandmark() throws Exception {
        Long firstId = landmarkRepository.findAll().stream().findFirst().get().getId();
        mockMvc.
                perform(get("/edit/landmark/"+firstId))
                .andExpect(status().isOk())
                .andExpect(view().name("landmark-edit"));
    }

    @Test
    void getEditTown() throws Exception {
        Long firstId = townRepository.findAll().stream().findFirst().get().getId();
        mockMvc.
                perform(get("/edit/town/"+firstId))
                .andExpect(status().isOk())
                .andExpect(view().name("town-edit"));
    }

    @Test
    void testEditLandmark() throws Exception {
        Long firstId = landmarkRepository.findAll().stream().findFirst().get().getId();
        Long initial = landmarkRepository.count();
        mockMvc.perform(post("/edit/landmark/" + firstId).
                param("name","editedLandmark").
                param("description",DESCRIPTION).
                param("town","Sofia").
                param("pictureURL",IMAGE_URL).
                with(csrf()).
                contentType(MediaType.APPLICATION_FORM_URLENCODED));

//        Assertions.assertEquals(initial, townRepository.count());

        Optional<Landmark> editedLandmark = landmarkRepository.findById(firstId);

        Assertions.assertTrue(editedLandmark.isPresent());
        Landmark landmark = editedLandmark.get();

        Assertions.assertEquals("editedLandmark", landmark.getName());
        Assertions.assertEquals(DESCRIPTION, landmark.getDescription());
        Assertions.assertEquals(IMAGE_URL, landmark.getPictureURL());
    }

    @Test
    void testEditLandmarkFail() throws Exception {
        Long firstId = landmarkRepository.findAll().stream().findFirst().get().getId();
        Long initial = landmarkRepository.count();
        mockMvc.perform(post("/edit/landmark/" + firstId).
                param("name","editedLandmark").
                param("description",DESCRIPTION).
                param("town","Sofia")).andExpect(redirectedUrl("/edit/landmark/"+firstId));

    }

    @Test
    void getEditGuide() throws Exception {
        Long firstId = guideRepository.findAll().stream().findFirst().get().getId();
        mockMvc.
                perform(get("/edit/guide/"+firstId))
                .andExpect(status().isOk())
                .andExpect(view().name("guide-edit"));
    }

    @Test
    void userNotFoundExceptionTest () throws Exception {
        mockMvc.
                perform(get("/users/destinations/FALSE"))
                .andExpect(status().isOk())
                .andExpect(view().name("user-not-found"));
    }

    @Test
    void getAddGuide () throws Exception {
        mockMvc.
                perform(get("/add/guide"))
                .andExpect(status().isOk())
                .andExpect(view().name("guide-add"));
    }



//    @Test
//    void getEditDay() throws Exception {
//
//        Long firstIdExcursion = excursionRepository.findAll().stream().findFirst().get().getId();
//        Day day = new Day(1,null,excursionRepository.findById(firstIdExcursion).orElse(null),null);
//        dayRepository.save(day);
//        Long firstIdDay = dayRepository.findAll().stream().findFirst().get().getId();
//
//        mockMvc.
//                perform(get("/edit/guide/"+firstIdDay+"/"+firstIdExcursion))
//                .andExpect(status().isOk())
//                .andExpect(view().name("day-edit"));
//        dayRepository.deleteById(firstIdDay);
//    }

    }

