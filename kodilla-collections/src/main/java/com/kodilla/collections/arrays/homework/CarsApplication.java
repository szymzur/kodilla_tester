package com.kodilla.collections.arrays.homework;

import com.kodilla.collections.interfaces.homework.Car;
import com.kodilla.collections.interfaces.homework.Mazda;
import com.kodilla.collections.interfaces.homework.Suzuki;
import com.kodilla.collections.interfaces.homework.Toyota;

import java.util.Random;

public class CarsApplication {
    private static final Random random = new Random();

    public static void main(String[] args) {
        int arraySize = random.nextInt(15) + 1;
        CarWithNames[] cars = new CarWithNames[arraySize];

        for (int i = 0; i < arraySize; i++) {
            cars[i] = drawCar();
        }

        if (cars == null || cars.length == 0) {
            System.out.println("No cars available.");
        } else {
            for (CarWithNames car : cars) {
                CarUtils.describeCar(car.name, car.car);
            }
        }
    }

    public static CarWithNames drawCar() {
        int carType = random.nextInt(3);
        Car car;
        String carName;

        switch (carType) {
            case 0:
                car = new Suzuki();
                carName = "Suzuki";
                break;
            case 1:
                car = new Toyota();
                carName = "Toyota";
                break;
            case 2:
                car = new Mazda();
                carName = "Mazda";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + carType);
        }

        int speedIncreases = random.nextInt(5) + 1;
        for (int i = 0; i < speedIncreases; i++) {
            car.increaseSpeed();
        }

        return new CarWithNames(carName, car);
    }

    static class CarWithNames {
        String name;
        Car car;

        CarWithNames(String name, Car car) {
            this.name = name;
            this.car = car;
        }
    }
}