package com.example.project.model.entity;

public enum StarsEnum {
S1(1),S2(2),S3(3),S4(4),S5(5);

    StarsEnum(int value) {
        this.value = value;
    }

    private int value;

    public String toString() {
        return Integer.toString(value);
    }
}
