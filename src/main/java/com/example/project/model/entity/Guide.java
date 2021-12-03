package com.example.project.model.entity;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.util.Set;

@Entity
@Table(name = "guides")
public class Guide extends BaseEntity{
    private String fullName;
    private Integer age;
    private String pictureUrl;
    private String description;
    private Set<Excursion> excursion;

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
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Column(columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
@OneToMany(mappedBy = "guide")

    public Set<Excursion> getExcursion() {
        return excursion;
    }

    public void setExcursion(Set<Excursion> excursion) {
        this.excursion = excursion;
    }
}
