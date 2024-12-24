package com.kodilla.interfaces.homework;

public class CarRace {
    public static void main(String[] args) {
        Car suzuki = new Suzuki();
        Car toyota = new Toyota();
        Car mazda = new Mazda();

        doRace(suzuki);
        doRace(toyota);
        doRace(mazda);
    }

    private static void doRace(Car car) {
    car.increaseSpeed();
    car.decreaseSpeed();
    car.increaseSpeed();
    car.decreaseSpeed();
    car.increaseSpeed();
        System.out.println("Final speed: " + car.getSpeed());
    }
}