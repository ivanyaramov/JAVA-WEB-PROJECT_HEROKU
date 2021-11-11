package com.example.project.repository;

import com.example.project.model.entity.BookingHotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<BookingHotel, Long> {

}
