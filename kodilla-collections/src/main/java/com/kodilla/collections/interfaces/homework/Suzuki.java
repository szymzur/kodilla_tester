package com.kodilla.collections.interfaces.homework;

public class Suzuki implements Car {
    private int speed;

    public Suzuki() {
        this.speed = 0;
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public void increaseSpeed() {
        speed += 20;
    }

    @Override
    public void decreaseSpeed() {
        speed -= 5;
        if (speed < 0) speed = 0;
    }

    @Override
    public String getName() {
        return "Suzuki";
    }
}