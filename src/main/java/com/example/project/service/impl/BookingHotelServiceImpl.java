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
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

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

    @Override
    public boolean checkIfBookingIsOlderThan1Year(Long id) {
        BookingHotel bookingHotel = bookingHotelRepository.findById(id).orElse(null);
        LocalDate dateOfBooking = bookingHotel.getStartDate();
        LocalDate now = LocalDate.now();


        return now.isAfter(dateOfBooking.plusYears(1));

    }

    @Override
    @Scheduled(cron = "${schedulers.cron}")
    public void deleteBookingsIfOlderThan1Year() {
        for(BookingHotel b: bookingHotelRepository.findAll()){
            if(checkIfBookingIsOlderThan1Year(b.getId())){
                bookingHotelRepository.delete(b);
            }
        }
    }


}
