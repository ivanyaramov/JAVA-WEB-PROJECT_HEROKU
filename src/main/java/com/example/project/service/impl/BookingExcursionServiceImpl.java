package com.example.project.service.impl;

import com.example.project.model.entity.BookingExcursion;
import com.example.project.model.entity.Excursion;
import com.example.project.model.entity.UserEntity;
import com.example.project.model.service.BookingExcursionServiceModel;
import com.example.project.repository.BookingExcursionRepository;
import com.example.project.service.BookingExcursionService;
import com.example.project.service.ExcursionService;
import com.example.project.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class BookingExcursionServiceImpl implements BookingExcursionService {
    private final ModelMapper modelMapper;
    private final BookingExcursionRepository bookingExcursionRepository;
    private final ExcursionService excursionService;
    private final UserService userService;

    public BookingExcursionServiceImpl(ModelMapper modelMapper, BookingExcursionRepository bookingExcursionRepository, ExcursionService excursionService, UserService userService) {
        this.modelMapper = modelMapper;
        this.bookingExcursionRepository = bookingExcursionRepository;
        this.excursionService = excursionService;
        this.userService = userService;
    }

    @Override
    public void createBooking(BookingExcursionServiceModel bookingExcursionServiceModel) {
        BookingExcursion booking= modelMapper.map(bookingExcursionServiceModel, BookingExcursion.class);
        Excursion excursion = excursionService.findById(bookingExcursionServiceModel.getExcursionId());
        UserEntity user = userService.findByUsername(bookingExcursionServiceModel.getUsername());
        booking.setExcursion(excursion);
        booking.setStartDate(excursion.getStartDate());
        booking.setEndDate(excursion.getEndDate());
        booking.setFinished(false);
        booking.setUser(user);
        bookingExcursionRepository.save(booking);

    }
}
