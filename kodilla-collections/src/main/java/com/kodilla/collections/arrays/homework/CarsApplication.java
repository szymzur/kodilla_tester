package com.kodilla.collections.arrays.homework;

import com.kodilla.interfaces.homework.Car;
import com.kodilla.interfaces.homework.Mazda;
import com.kodilla.interfaces.homework.Suzuki;
import com.kodilla.interfaces.homework.Toyota;

import java.util.Random;

public class CarsApplication {
    private static final Random random = new Random();

    public static void main(String[] args) {
        int arraySize = random.nextInt(15) + 1;
        Car[] cars = new Car[arraySize];

        for (int i = 0; i < arraySize; i++) {
            cars[i] = drawCar();
        }

        for (Car car : cars) {
            CarUtils.describeCar(car);
        }
    }

    public static Car drawCar() {
        int carType = random.nextInt(3);
        Car car;

        switch (carType) {
            case 0:
                car = new Suzuki();
                break;
            case 1:
                car = new Toyota();
                break;
            case 2:
                car = new Mazda();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + carType);
        }

        int speedIncreases = random.nextInt(5) + 1;
        for (int i = 0; i < speedIncreases; i++) {
            car.increaseSpeed();
        }

        return car;
    }
}