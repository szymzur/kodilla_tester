package com.kodilla.collections.lists.homework;

import com.kodilla.collections.arrays.homework.CarUtils;
import com.kodilla.collections.interfaces.homework.Car;
import com.kodilla.collections.interfaces.homework.Mazda;
import com.kodilla.collections.interfaces.homework.Suzuki;
import com.kodilla.collections.interfaces.homework.Toyota;
import java.util.ArrayList;
import java.util.List;

public class CarsListApplication {
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();

        Suzuki suzuki = new Suzuki();
        Toyota toyota = new Toyota();
        Mazda mazda = new Mazda();

        cars.add(suzuki);
        cars.add(toyota);
        cars.add(mazda);

        System.out.println("Initial collection:");
        for (Car car : cars) {
            CarUtils.describeCar(car);
        }

        cars.remove(1);

        cars.remove(mazda);

        System.out.println("Final collection size: " + cars.size());
        for (Car car : cars) {
            CarUtils.describeCar(car);
        }
    }
}