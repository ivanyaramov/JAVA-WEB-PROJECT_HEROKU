package com.example.project.service.impl;

import com.example.project.model.entity.BookingHotel;
import com.example.project.model.entity.Hotel;
import com.example.project.model.entity.UserEntity;
import com.example.project.model.service.BookingHotelServiceModel;
import com.example.project.repository.BookingHotelRepository;
import com.example.project.service.BookingHotelService;
import com.example.project.service.HotelService;
import com.example.project.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class BookingHotelServiceImpl implements BookingHotelService {
    private final ModelMapper modelMapper;
    private final BookingHotelRepository bookingHotelRepository;
    private final HotelService hotelService;
    private final UserService userService;

    public BookingHotelServiceImpl(ModelMapper modelMapper, BookingHotelRepository bookingHotelRepository, HotelService hotelService, UserService userService) {
        this.modelMapper = modelMapper;
        this.bookingHotelRepository = bookingHotelRepository;
        this.hotelService = hotelService;
        this.userService = userService;
    }


    @Override
    public void createBooking(BookingHotelServiceModel bookingHotelServiceModel) {
        BookingHotel booking= modelMapper.map(bookingHotelServiceModel, BookingHotel.class);
        Hotel hotel = hotelService.findById(bookingHotelServiceModel.getHotelId());
        UserEntity user = userService.findByUsername(bookingHotelServiceModel.getUsername());
        booking.setHotel(hotel);
        booking.setUser(user);
        bookingHotelRepository.save(booking);
    }


}
