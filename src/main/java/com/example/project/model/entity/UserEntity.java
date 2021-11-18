package com.example.project.model.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity{
    private String username;
    private String fullName;
    private int age;
    private String password;
    private String email;
    private String telephoneNum;
    private boolean isActive;
    private Set<UserRoleEntity> roles = new HashSet<>();
    private Set<BookingExcursion> bookingExcursions;
    private Set<BookingHotel> bookingHotels;
@Column
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Column(nullable = false, unique = true)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    @Column(nullable = false)
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    @Column(nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @Column(unique = true, nullable = false)
    @Email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
@ManyToMany(fetch = FetchType.EAGER)
    public Set<UserRoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(Set<UserRoleEntity> roles) {
        this.roles = roles;
    }
@Column
    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
@Column
    public String getTelephoneNum() {
        return telephoneNum;
    }

    public void setTelephoneNum(String telephoneNum) {
        this.telephoneNum = telephoneNum;
    }
@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    public Set<BookingExcursion> getBookingExcursions() {
        return bookingExcursions;
    }

    public void setBookingExcursions(Set<BookingExcursion> bookingExcursions) {
        this.bookingExcursions = bookingExcursions;
    }
@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    public Set<BookingHotel> getBookingHotels() {
        return bookingHotels;
    }

    public void setBookingHotels(Set<BookingHotel> bookingHotels) {
        this.bookingHotels = bookingHotels;
    }
}


