package com.example.project.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
@Entity
@Table(name = "hotels")
public class Hotel extends BaseEntity {
    private String name;
    private BigDecimal pricePerNightAdult;
    private BigDecimal pricePerNightChild;
    private Town town;
@ManyToOne
    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }

    @Column(nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
@Column(nullable = false)
@Positive
    public BigDecimal getPricePerNightAdult() {
        return pricePerNightAdult;
    }

    public void setPricePerNightAdult(BigDecimal pricePerNight) {
        this.pricePerNightAdult = pricePerNight;
    }

@Column
@Positive
    public BigDecimal getPricePerNightChild() {
        return pricePerNightChild;
    }

    public void setPricePerNightChild(BigDecimal pricePerNightChild) {
        this.pricePerNightChild = pricePerNightChild;
    }
}
