package com.example.project.service.impl;

import com.example.project.model.binding.RoleBindingModel;
import com.example.project.model.binding.UserProfileBindingModel;
import com.example.project.model.entity.UserEntity;
import com.example.project.model.entity.UserRoleEntity;
import com.example.project.model.entity.UserRoleEnum;
import com.example.project.model.service.UserProfileServiceModel;
import com.example.project.model.service.UserRegisterServiceModel;
import com.example.project.model.view.BookingExcursionViewModel;
import com.example.project.model.view.BookingHotelViewModel;
import com.example.project.model.view.UserEntityViewModel;
import com.example.project.repository.UserRepository;
import com.example.project.service.HotelService;
import com.example.project.service.UserRoleService;
import com.example.project.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    private UserEntity testUser;
    private UserEntity testUser2;
    private UserRoleEntity adminRole, moderatorRole, userRole;

    private ProjectUserServiceImpl serviceToTest;
    private UserService userServiceToTest;


    @Mock
    private UserRepository mockUserRepository;
    @Mock
    private UserRoleService mockUserRoleService;
    @Mock
    private PasswordEncoder mockPasswordEncoder;


    @Mock
    private HotelService mockHotelService;


    @BeforeEach
    void init() {

        //ARRANGE
        serviceToTest = new ProjectUserServiceImpl(mockUserRepository);
        userServiceToTest = new UserServiceImpl(mockUserRoleService, mockUserRepository, mockPasswordEncoder, serviceToTest ,new ModelMapper(), mockHotelService);


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
        Long count = mockUserRepository.count();
    }


    @Test
    void testUserNotFound() {
        Assertions.assertThrows(
                UsernameNotFoundException.class,
                () -> serviceToTest.loadUserByUsername("invalid")
        );
    }

    @Test
    void testUserFound() {

        // Arrange
        Mockito.when(mockUserRepository.findByUsername(testUser.getUsername())).
                thenReturn(Optional.of(testUser));

        // Act
        var actual = serviceToTest.loadUserByUsername(testUser.getUsername());

        // Assert

        String expectedRoles = "ROLE_ADMIN, ROLE_MODERATOR, ROLE_USER";
        String actualRoles = actual.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(
                Collectors.joining(", "));

        Assertions.assertEquals(actual.getUsername(), testUser.getUsername());
        Assertions.assertEquals(expectedRoles, actualRoles);
    }
    @Test
    void TestReturnAllUsers(){
        List<UserEntity> listExpected = List.of(testUser,testUser2);
        int initial = 3;
        Mockito.when(mockUserRepository.findAll()).thenReturn(listExpected);

        List<UserEntityViewModel> listActual = userServiceToTest.getAllUsersView();
        Assertions.assertEquals(listExpected.size(), listActual.size());
        for(int i=0; i<listExpected.size();i++)
        Assertions.assertEquals(listExpected.get(i).getUsername(), listActual.get(i).getUsername());

    }
}
