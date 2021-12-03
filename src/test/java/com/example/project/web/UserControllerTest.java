package com.example.project.web;

import com.example.project.model.entity.UserEntity;
import com.example.project.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;
    private UserEntity testUser;
//    @BeforeEach
//    void setUp() {
//        testUser = new UserEntity();
//        testUser.setPassword("12345");
//        testUser.setUsername(TEST_USER_USERNAME);
//        testUser.setEmail(TEST_USER_EMAIL);
//        testUser.setTelephoneNum(TEST_USER_TEL);
//        testUser.setAge(TEST_USER_AGE);
//        testUser.setFullName("Ivan Yaramov");
//
//        testUser = userRepository.save(testUser);
//    }

    @AfterEach
    void tearDown() {
        userRepository.deleteAll();
    }

    @Test
    void testOpenRegisterForm() throws Exception {
        mockMvc.
                perform(get("/users/register"))
                .andExpect(status().isOk())
                .andExpect(view().name("register"));
    }

    private static final String TEST_USER_EMAIL = "pesho@example.com";
    private static final String TEST_USER_USERNAME = "admin2";
    private static final String TEST_USER_USERNAME2 = "admin3";
    private static final int TEST_USER_AGE = 12;
    private static final String TEST_USER_TEL = "087877323";

    @Test
    void testRegisterUser() throws Exception {
        Long initial = userRepository.count();
        mockMvc.perform(post("/users/register").
                param("username",TEST_USER_USERNAME).
                param("fullName","Pesho Petrov").
                param("email",TEST_USER_EMAIL).
                param("age",String.valueOf(TEST_USER_AGE)).
                param("telephoneNum", TEST_USER_TEL).
                param("password","12345").
                param("confirmPassword","12345").
                with(csrf()).
                contentType(MediaType.APPLICATION_FORM_URLENCODED)
        ).
                andExpect(status().is3xxRedirection());

        Assertions.assertEquals(initial + 1, userRepository.count());

        Optional<UserEntity> newlyCreatedUserOpt = userRepository.findByUsername(TEST_USER_USERNAME);

        Assertions.assertTrue(newlyCreatedUserOpt.isPresent());

        UserEntity newlyCreatedUser = newlyCreatedUserOpt.get();

        Assertions.assertEquals(TEST_USER_AGE, newlyCreatedUser.getAge());
        Assertions.assertEquals(TEST_USER_USERNAME, newlyCreatedUser.getUsername());
        Assertions.assertEquals(TEST_USER_EMAIL, newlyCreatedUser.getEmail());
        Assertions.assertEquals(TEST_USER_TEL, newlyCreatedUser.getTelephoneNum());

    }

    @Test
    void testLoginUser() throws Exception {
        Long initial = userRepository.count();
        mockMvc.perform(post("/users/login").
                param("username",TEST_USER_USERNAME2).
                param("password","12345").
                with(csrf()).
                contentType(MediaType.APPLICATION_FORM_URLENCODED)
        ).
                andExpect(status().isOk());

        Assertions.assertEquals(initial, userRepository.count());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken) && authentication!=null) {
            String currentUserName = authentication.getName();
            Assertions.assertEquals(currentUserName, TEST_USER_USERNAME2);
        }




    }
    @Test
    void testOpenLoginForm() throws Exception {
        mockMvc.
                perform(get("/users/login"))
                .andExpect(status().isOk())
                .andExpect(view().name("login"));
    }









}
