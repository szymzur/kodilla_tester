package com.kodilla.inheritance.homework;

public class AppSys {
    public static void main(String[] args) {
        OperatingSystem windows = new Windows(2020);
        OperatingSystem linux = new Linux(1997);

        windows.turnOn();
        windows.turnOff();
        System.out.println("Windows release year: " + windows.getReleaseYear());

        linux.turnOn();
        linux.turnOff();
        System.out.println("Linux release year: " + linux.getReleaseYear());
    }
}

