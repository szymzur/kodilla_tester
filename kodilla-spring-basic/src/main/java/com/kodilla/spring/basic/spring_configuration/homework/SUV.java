package com.kodilla.spring.basic.spring_configuration.homework;

import java.time.LocalTime;

public class SUV implements Car {

    @Override
    public boolean hasHeadlightsTurnedOn() {
        LocalTime now = LocalTime.now();
        return now.isAfter(LocalTime.of(20, 0)) || now.isBefore(LocalTime.of(6, 0));
    }

    @Override
    public String getCarType() {
        return "SUV";
    }
}