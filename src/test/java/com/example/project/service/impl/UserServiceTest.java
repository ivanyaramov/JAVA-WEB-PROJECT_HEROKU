package com.example.project.service.impl;

import com.example.project.model.binding.RoleBindingModel;
import com.example.project.model.entity.UserEntity;
import com.example.project.model.entity.UserRoleEntity;
import com.example.project.model.entity.UserRoleEnum;
import com.example.project.model.service.UserProfileServiceModel;
import com.example.project.model.service.UserRegisterServiceModel;
import com.example.project.model.view.UserEntityViewModel;
import com.example.project.repository.UserRepository;
import com.example.project.service.HotelService;
import com.example.project.service.UserRoleService;
import com.example.project.service.UserService;
import com.example.project.web.NoAccessException;
import com.example.project.web.UserNotFoundException;
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
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;


@ExtendWith(MockitoExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserServiceTest {

    private UserEntity testUser;
    private UserEntity testUser2;
    private UserRoleEntity adminRole, moderatorRole, userRole;

    private ProjectUserServiceImpl serviceToTest;
    private UserService userServiceToTest;
    private UserService userServiceToTest2;
    @Autowired
    private ModelMapper modelMapper;


    @Mock
    private UserRepository mockUserRepository;
    @Mock
    private UserRoleService mockUserRoleService;
    @Autowired
    private PasswordEncoder mockPasswordEncoder;
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserRoleService userRoleService2;


    @Mock
    private HotelService mockHotelService;

    public UserServiceTest() {

    }


    @BeforeEach
    void init() {

        //ARRANGE
        serviceToTest = new ProjectUserServiceImpl(mockUserRepository);
        userServiceToTest = new UserServiceImpl(mockUserRoleService, mockUserRepository, mockPasswordEncoder, serviceToTest ,new ModelMapper(), mockHotelService);
        userServiceToTest2 = new UserServiceImpl(userRoleService2, userRepository, mockPasswordEncoder, serviceToTest ,new ModelMapper(), mockHotelService);


        adminRole = new UserRoleEntity();
        adminRole.setRole(UserRoleEnum.ADMIN);
        moderatorRole = new UserRoleEntity();
        moderatorRole.setRole(UserRoleEnum.MODERATOR);
        userRole = new UserRoleEntity();
        userRole.setRole(UserRoleEnum.USER);



        testUser = new UserEntity();
        testUser.setId(1L);
        testUser.setUsername("admin2");
        testUser.setEmail("asaff!@gmal.com");
        testUser.setAge(10);
        testUser.setPassword("12345");
        Set<UserRoleEntity> set1 = new HashSet<>();
        set1.addAll(Set.of(adminRole, userRole, moderatorRole));
        testUser.setRoles(set1);
        testUser2 = new UserEntity();
        testUser2.setId(2L);
        testUser2.setAge(11);
        testUser2.setUsername("admin3");
        testUser2.setEmail("asaff!@gmal.comd");
        testUser2.setPassword("12345");
        Set<UserRoleEntity> set2 = new HashSet<>();
        set2.addAll(Set.of(userRole, moderatorRole));

        testUser2.setRoles(set2);
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

    @Test
    void TestReturnAllUsersNormal(){
        List<UserEntity> listExpected = List.of(testUser,testUser2);
        int initial = 3;
        Mockito.when(mockUserRepository.findAll()).thenReturn(listExpected);

        List<UserEntity> listActual = userServiceToTest.getAllUsers();
        Assertions.assertEquals(listExpected.size(), listActual.size());
        for(int i=0; i<listExpected.size();i++)
            Assertions.assertEquals(listExpected.get(i).getUsername(), listActual.get(i).getUsername());

    }

    @Test
    void TestEditUser(){

        UserProfileServiceModel userProfileServiceModel = modelMapper.map(testUser, UserProfileServiceModel.class);
        userProfileServiceModel.setAge(55);
        Mockito.when(mockUserRepository.findByUsername(testUser.getUsername())).thenReturn(Optional.of(modelMapper.map(userProfileServiceModel, UserEntity.class)));
        userServiceToTest.editUser(testUser.getUsername(),userProfileServiceModel);
        var actual = userServiceToTest.findByUsername(testUser.getUsername());
        Assertions.assertEquals(userProfileServiceModel.getAge(), actual.getAge());

    }

    @Test
    void TestCanAcessForFirst(){
        Mockito.when(mockUserRepository.findByUsername(testUser.getUsername())).thenReturn(Optional.of(testUser));
        Assertions.assertThrows(UserNotFoundException.class,() -> userServiceToTest.canAccess("random", testUser.getUsername()));
    }

    @Test
    void TestCanAcessForSecond(){
        Mockito.when(mockUserRepository.findByUsername(testUser.getUsername())).thenReturn(Optional.of(testUser));
        Assertions.assertThrows(UserNotFoundException.class,() -> userServiceToTest.canAccess(testUser.getUsername(), "random"));
    }

    @Test
    void TestHasAccess(){
        Mockito.when(mockUserRepository.findByUsername(testUser.getUsername())).thenReturn(Optional.of(testUser));
      Assertions.assertTrue(userServiceToTest.canAccess(testUser.getUsername(), testUser.getUsername()));
    }

    @Test
    void TestHasNoAccess(){
        Mockito.when(mockUserRepository.findByUsername(testUser.getUsername())).thenReturn(Optional.of(testUser));
        Mockito.when(mockUserRepository.findByUsername(testUser2.getUsername())).thenReturn(Optional.of(testUser2));
        Assertions.assertThrows(NoAccessException.class,()->userServiceToTest.canAccess(testUser.getUsername(), testUser2.getUsername()));
    }
    @Test
    void TestRemoveRole(){
        Mockito.when(mockUserRepository.findById(testUser2.getId())).thenReturn(Optional.of(testUser2));

        Mockito.when(mockUserRoleService.findByRole(UserRoleEnum.MODERATOR)).thenReturn(moderatorRole);
        RoleBindingModel roleBindingModel = new RoleBindingModel();
        roleBindingModel.setUserRoleEnum(UserRoleEnum.MODERATOR);
        userServiceToTest.removeRole(testUser2.getId(), roleBindingModel);
        var actual = userServiceToTest.findById(testUser2.getId());
        Assertions.assertEquals(1, actual.getRoles().size());
        String actualRole = actual.getRoles().stream().findFirst().get().getRole().toString();
        Assertions.assertEquals(userRole.getRole().toString(), actualRole);
    }

    @Test
    void TestAddRole(){
        Mockito.when(mockUserRepository.findById(testUser2.getId())).thenReturn(Optional.of(testUser2));

        Mockito.when(mockUserRoleService.findByRole(UserRoleEnum.ADMIN)).thenReturn(adminRole);
        RoleBindingModel roleBindingModel = new RoleBindingModel();
        roleBindingModel.setUserRoleEnum(UserRoleEnum.ADMIN);
        userServiceToTest.addRole(testUser2.getId(), roleBindingModel);
        var actual = userServiceToTest.findById(testUser2.getId());
        Assertions.assertEquals(3, actual.getRoles().size());
        String actualRoles = actual.getRoles().stream().map(r->r.getRole().toString()).collect(Collectors.joining(", "));

    }

    @Test
    void TestCreateUsers(){
//        Mockito.when(mockUserRoleService.findByRole(UserRoleEnum.ADMIN)).thenReturn(adminRole);
//        Mockito.when(mockUserRoleService.findByRole(UserRoleEnum.MODERATOR)).thenReturn(moderatorRole);
//        Mockito.when(mockUserRoleService.findByRole(UserRoleEnum.USER)).thenReturn(userRole);
        userRepository.deleteAll();
        userServiceToTest2.initaliseUsers();
        Assertions.assertEquals(3, userRepository.count());
    }


//    @Test
//    void TestRegisterAndLogin(){
//        UserRegisterServiceModel userRegisterServiceModel = new UserRegisterServiceModel();
//        userRegisterServiceModel.setUsername("testuser2");
//        userRegisterServiceModel.setAge(22);
//        userRegisterServiceModel.setEmail("test@gmail.com");
//        userRegisterServiceModel.setPassword("12345");
//        userRegisterServiceModel.setFullName("aleksandar banov");
//        userRegisterServiceModel.setTelephoneNum("087464625");
//        Mockito.when(mockUserRoleService.findByRole(UserRoleEnum.USER)).thenReturn(userRole);
//        UserEntity testuser3 = modelMapper.map(userRegisterServiceModel, UserEntity.class);
//        testuser3.setActive(true);
//        testuser3.setPassword(mockPasswordEncoder.encode(userRegisterServiceModel.getPassword()));
//        testuser3.setRoles(Set.of(userRole));
//        Mockito.when(mockUserRepository.save(testUser2)).thenReturn(testUser2);
//        userServiceToTest.registerAndLoginUser(userRegisterServiceModel);
//
//        Assertions.assertEquals(3, mockUserRepository.count());
//
//    }

}
