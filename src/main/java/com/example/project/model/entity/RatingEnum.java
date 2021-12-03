package com.example.project.model.entity;

public enum RatingEnum {
    R1(1),R2(2),R3(3),R4(4),R5(5);

    RatingEnum(int value) {
        this.value = value;
    }

    private int value;

    public String toString() {
        return Integer.toString(value);
    }
}
