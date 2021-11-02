package com.example.project.model.view;

import java.util.Set;

public class CountryViewModel {
    private Long id;
    private String name;
    private Set<TownViewModel> towns;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<TownViewModel> getTowns() {
        return towns;
    }

    public void setTowns(Set<TownViewModel> towns) {
        this.towns = towns;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
