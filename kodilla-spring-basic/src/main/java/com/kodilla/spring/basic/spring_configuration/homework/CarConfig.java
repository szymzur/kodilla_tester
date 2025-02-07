package com.kodilla.spring.basic.spring_configuration.homework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalTime;
import java.time.Month;
import java.time.LocalDate;

@Configuration
public class CarConfig {

    @Bean
    public Car car() {
        Month month = LocalDate.now().getMonth();
        LocalTime now = LocalTime.now();

        Car car;

        switch (month) {
            case DECEMBER:
            case JANUARY:
            case FEBRUARY:
                car = new SUV();
                break;
            case JUNE:
            case JULY:
            case AUGUST:
                car = new Cabrio();
                break;
            default:
                car = new Sedan();
                break;
        }

        return car;
    }
}