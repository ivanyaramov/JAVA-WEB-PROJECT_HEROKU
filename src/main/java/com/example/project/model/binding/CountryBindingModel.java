package com.example.project.model.binding;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CountryBindingModel {
    private String name;
@NotNull
@Size(min = 1)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
