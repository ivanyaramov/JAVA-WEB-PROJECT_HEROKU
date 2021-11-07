package com.example.project.model.view;

import com.example.project.model.entity.Day;

import java.time.LocalDate;
import java.util.Set;

public class ExcursionViewModel {
    private Long id;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer capacity;
    private String pictureUrl;
    private Set<DayViewModel> days;
    private GuideViewModel guide;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public Set<DayViewModel> getDays() {
        return days;
    }

    public void setDays(Set<DayViewModel> days) {
        this.days = days;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public GuideViewModel getGuide() {
        return guide;
    }

    public void setGuide(GuideViewModel guide) {
        this.guide = guide;
    }
}
