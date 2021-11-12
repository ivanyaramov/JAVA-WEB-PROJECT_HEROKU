package com.example.project.repository;

import com.example.project.model.entity.BookingHotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingHotelRepository extends JpaRepository<BookingHotel, Long> {

}
