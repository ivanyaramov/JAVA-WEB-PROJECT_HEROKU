package com.example.project.repository;

import com.example.project.model.entity.Excursion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExcursionRepository extends JpaRepository<Excursion, Long> {
    Optional<Excursion> getExcursionByName(String name);
}
