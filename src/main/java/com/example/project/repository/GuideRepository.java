package com.example.project.repository;

import com.example.project.model.entity.Guide;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GuideRepository extends JpaRepository<Guide, Long> {
    Optional<Guide> findByFullName(String fullName);
}
