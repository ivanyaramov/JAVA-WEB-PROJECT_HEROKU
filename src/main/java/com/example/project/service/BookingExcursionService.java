package com.example.project.service;

import com.example.project.model.entity.BookingExcursion;
import com.example.project.model.service.BookingExcursionServiceModel;

public interface BookingExcursionService {
    void createBooking(BookingExcursionServiceModel bookingExcursionServiceModel);

    BookingExcursion findById(Long bookingid);
    boolean checkIfBookingIsFinished(Long id);
    void setBookingAsFinishedIfNeeded(Long id);

}
