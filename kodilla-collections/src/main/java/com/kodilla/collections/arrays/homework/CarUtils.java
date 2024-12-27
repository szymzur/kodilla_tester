package com.kodilla.collections.arrays.homework;

import com.kodilla.collections.interfaces.homework.Car;

public class CarUtils {
    public static void describeCar(String carName, Car car) {
        System.out.println("Car: " + carName);
        System.out.println("Speed: " + car.getSpeed());
    }
}
