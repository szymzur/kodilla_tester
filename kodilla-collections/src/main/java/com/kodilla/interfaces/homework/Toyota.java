package com.kodilla.interfaces.homework;

public class Toyota implements Car {
    private int speed;

    public Toyota() {
        this.speed = 0;
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public void increaseSpeed() {
        speed += 17;
    }

    @Override
    public void decreaseSpeed() {
        speed -= 5;
        if (speed < 0) speed = 0;
    }
}