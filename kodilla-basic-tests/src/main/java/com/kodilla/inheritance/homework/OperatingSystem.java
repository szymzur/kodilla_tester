package com.kodilla.inheritance.homework;

public class OperatingSystem {
    private int releaseYear;

    public OperatingSystem(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void turnOn() {
        System.out.println("Operating system is turning on...");
    }

    public void turnOff() {
        System.out.println("Operating system is turning off...");
    }

    public int getReleaseYear() {
        return releaseYear;
    }
}