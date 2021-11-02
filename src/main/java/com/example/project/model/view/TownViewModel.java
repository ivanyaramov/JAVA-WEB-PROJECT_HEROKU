package com.example.project.model.view;

import com.example.project.model.entity.Country;
import com.example.project.model.entity.Hotel;
import com.example.project.model.entity.Landmark;

import java.util.Set;

public class TownViewModel {
    private String name;
    private Set<Landmark> landmarks;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Landmark> getLandmarks() {
        return landmarks;
    }

    public void setLandmarks(Set<Landmark> landmarks) {
        this.landmarks = landmarks;
    }
}
