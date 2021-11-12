package com.example.project.service;

import com.example.project.model.entity.Hotel;

public interface HotelService {
    void initialiseHotels();
    Hotel findById(Long id);
}
