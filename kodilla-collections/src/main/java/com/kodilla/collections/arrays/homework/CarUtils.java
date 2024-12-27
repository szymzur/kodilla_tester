package com.kodilla.collections.arrays.homework;

import com.kodilla.collections.interfaces.homework.Car;

public class CarUtils {
    public static void describeCar(Car car) {
        System.out.println("Car: " + car.getName());
        System.out.println("Speed: " + car.getSpeed());
    }
}