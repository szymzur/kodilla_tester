package com.kodilla.interfaces.homework;

public class Mazda implements Car {
    private int speed;

    public Mazda() {
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
        speed -= 6;
        if (speed < 0); speed = 0;
    }
}
