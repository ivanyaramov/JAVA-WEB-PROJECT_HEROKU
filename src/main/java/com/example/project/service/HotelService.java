package com.example.project.service;

import com.example.project.model.entity.Hotel;
import com.example.project.model.service.HotelServiceModel;

import java.math.BigDecimal;

public interface HotelService {
    void initialiseHotels();
    Hotel findById(Long id);

    BigDecimal priceOfHotelBooking(BigDecimal countOfChildren, BigDecimal countOfAdults, Long id);

    void createHotel(HotelServiceModel hotelServiceModel);
}
