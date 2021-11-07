package com.example.project.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "excursion_bookings")
public class BookingExcursion extends BaseEntity{
    private UserEntity user;
    private Excursion excursion;
    private Integer countOfAdults;
    private Integer countOfChildren;
@ManyToOne
    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
@Column
    public Integer getCountOfAdults() {
        return countOfAdults;
    }

    public void setCountOfAdults(Integer countOfAdults) {
        this.countOfAdults = countOfAdults;
    }
@Column
    public Integer getCountOfChildren() {
        return countOfChildren;
    }

    public void setCountOfChildren(Integer countOfChildren) {
        this.countOfChildren = countOfChildren;
    }
@ManyToOne
    public Excursion getExcursion() {
        return excursion;
    }

    public void setExcursion(Excursion excursion) {
        this.excursion = excursion;
    }
}
