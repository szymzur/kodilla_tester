package com.kodilla.abstracts.homework;

public class Square extends Shape {
    private double sideA;

    public Square(double sideA) {
        this.sideA = sideA;
    }

    @Override
    public double calculateArea() {
        return sideA * sideA;
    }

    @Override
    public double calculatePerimeter() {
        return sideA * 4;
    }
}

