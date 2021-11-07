package com.example.project.model.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
@Entity
@Table(name = "excursions")
public class Excursion  extends BaseEntity{
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer capacity;
    private String pictureUrl;
    private Guide guide;
    private Set<Day> days;


    public Excursion() {
    }

    public Excursion(String name, LocalDate startDate, LocalDate endDate, Integer capacity) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.capacity = capacity;
    }

    @Column(nullable = false, unique = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
@Column(nullable = false)
    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
@Column(nullable = false)
    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
    @OneToMany(mappedBy = "excursion", fetch = FetchType.EAGER)
    public Set<Day> getDays() {
        return days;
    }

    public void setDays(Set<Day> days) {
        this.days = days;
    }




    @Column(nullable = false)
    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
@Column
    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }
@OneToOne
    public Guide getGuide() {
        return guide;
    }

    public void setGuide(Guide guide) {
        this.guide = guide;
    }
}
