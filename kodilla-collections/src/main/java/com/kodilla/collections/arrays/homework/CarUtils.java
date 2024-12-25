package com.kodilla.collections.arrays.homework;

import com.kodilla.interfaces.homework.Car;

public class CarUtils {
    public static void describeCar(Car car) {
        System.out.println("Car details: ");
        System.out.println("Speed: " + car.getSpeed());
    }
}
