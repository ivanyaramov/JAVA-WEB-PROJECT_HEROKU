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
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

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

    @Override
    public BookingExcursion findById(Long bookingid) {
        return bookingExcursionRepository.findById(bookingid).orElse(null);
    }

    @Override
    public boolean checkIfBookingIsFinished(Long id) {
        BookingExcursion bookingExcursion = findById(id);
        return LocalDate.now().compareTo(bookingExcursion.getEndDate()) > 0;
    }
    @Scheduled(cron = "${schedulers.cron}")
    @Override
    public void setBookingAsFinishedIfNeeded() {
        for(BookingExcursion b: bookingExcursionRepository.findAll()) {
            if (checkIfBookingIsFinished(b.getId())) {
                b.setFinished(true);
                bookingExcursionRepository.save(b);
            }
        }
    }
}
