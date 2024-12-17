package com.kodilla.inheritance.homework;

public class Linux extends OperatingSystem {
    public Linux(int releaseYear) {
        super(releaseYear);
    }

    @Override
    public void turnOn() {
        System.out.println("Linux operating system is turning on...");
    }

    @Override
    public void turnOff() {
        System.out.println("Linux operating system is turning off...");
    }
}

