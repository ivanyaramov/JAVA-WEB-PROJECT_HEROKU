package com.example.project.service;

import com.example.project.model.entity.UserEntity;
import com.example.project.model.service.UserRegisterServiceModel;
import com.example.project.model.view.BookingExcursionViewModel;
import com.example.project.model.view.BookingHotelViewModel;

import java.util.List;

public interface UserService {

    boolean isUserNameFree(String username);
    void registerAndLoginUser(UserRegisterServiceModel userRegistrationServiceModel);
    UserEntity findByUsername(String username);

    boolean isEmailFree(String email);
    void initaliseUsers();
    UserEntity findById(Long id);
    List<BookingExcursionViewModel> getAllExcursionBookings(UserEntity userEntity);
    List<BookingHotelViewModel> getAllHotelBookings(UserEntity userEntity);
}
