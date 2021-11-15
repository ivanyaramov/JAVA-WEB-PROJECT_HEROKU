package com.example.project.model.binding;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LandmarkBindingModelEdit {
    private String name;
    private String description;
    private String pictureURL;

    @NotNull
    @Size(min = 1)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Size(min = 1)
    @NotNull
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @Size(min = 1)
    @NotNull
    public String getPictureURL() {
        return pictureURL;
    }

    public void setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
    }

}
