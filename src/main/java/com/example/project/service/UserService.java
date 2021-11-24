package com.example.project.service;

import com.example.project.model.binding.RoleBindingModel;
import com.example.project.model.binding.UserProfileBindingModel;
import com.example.project.model.binding.UserRegisterBindingModel;
import com.example.project.model.entity.UserEntity;
import com.example.project.model.service.UserProfileServiceModel;
import com.example.project.model.service.UserRegisterServiceModel;
import com.example.project.model.view.BookingExcursionViewModel;
import com.example.project.model.view.BookingHotelViewModel;
import com.example.project.model.view.UserEntityViewModel;

import java.util.List;

public interface UserService {

    boolean isUserNameFree(String username);
    void registerAndLoginUser(UserRegisterServiceModel userRegistrationServiceModel);
    UserEntity findByUsername(String username);

    boolean isEmailFree(String email);
    void initaliseUsers();
    UserEntity findById(Long id);
    List<BookingExcursionViewModel> getAllExcursionBookings(String username);
    List<BookingHotelViewModel> getAllHotelBookings(String username);

    List<UserEntityViewModel> getAllUsersView();
    List<UserEntity> getAllUsers();

    void addRole(Long userid, RoleBindingModel roleBindingModel);

    void removeRole(Long userid, RoleBindingModel roleBindingModel);

    UserProfileBindingModel mapUserToBindingModel(String username);

    void editUser(String username, UserProfileServiceModel userProfileServiceModel);
}
