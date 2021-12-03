package com.example.project.repository;

import com.example.project.model.entity.BookingExcursion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingExcursionRepository extends JpaRepository<BookingExcursion, Long> {
}
