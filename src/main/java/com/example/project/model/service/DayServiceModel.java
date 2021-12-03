package com.example.project.model.service;

public class DayServiceModel {
    private Long id;
    private Integer numberOfDay;
    private String description;
    private String town1;
    private String town2;
    private String town3;
    private String sleep;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSleep() {
        return sleep;
    }

    public void setSleep(String sleep) {
        this.sleep = sleep;
    }

    public Integer getNumberOfDay() {
        return numberOfDay;
    }

    public void setNumberOfDay(Integer numberOfDay) {
        this.numberOfDay = numberOfDay;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTown1() {
        return town1;
    }

    public void setTown1(String town1) {
        this.town1 = town1;
    }

    public String getTown2() {
        return town2;
    }

    public void setTown2(String town2) {
        this.town2 = town2;
    }

    public String getTown3() {
        return town3;
    }

    public void setTown3(String town3) {
        this.town3 = town3;
    }
}
