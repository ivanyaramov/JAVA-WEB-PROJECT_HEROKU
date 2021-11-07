package com.example.project.model.entity;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.util.Set;

@Entity
@Table(name = "guides")
public class Guide extends BaseEntity{
    private String fullName;
    private int age;
    private String pictureUrl;
    private String description;
    private Excursion excursion;

    public Guide() {
    }

    public Guide(String fullName, int age, String pictureUrl) {
        this.fullName = fullName;
        this.age = age;
        this.pictureUrl = pictureUrl;
    }
@Column(nullable = false)
    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    @Column(nullable = false)
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String name) {
        this.fullName = name;
    }
@Column
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
@Column(columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
@OneToOne(mappedBy = "guide")
    public Excursion getExcursion() {
        return excursion;
    }

    public void setExcursion(Excursion excursion) {
        this.excursion = excursion;
    }
}
