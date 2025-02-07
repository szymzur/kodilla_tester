package com.kodilla.spring.basic.spring_configuration;

import com.kodilla.spring.basic.spring_configuration.homework.Car;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.Month;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CarConfigTests {

    @Autowired
    private Car car;

    @Test
    public void testCarForWinter() {
        Month month = LocalDate.now().getMonth();
        if (month == Month.DECEMBER || month == Month.JANUARY || month == Month.FEBRUARY) {
            assertEquals("SUV", car.getCarType());
        }
    }

    @Test
    public void testCarForSummer() {
        Month month = LocalDate.now().getMonth();
        if (month == Month.JUNE || month == Month.JULY || month == Month.AUGUST) {
            assertEquals("Cabrio", car.getCarType());
        }
    }

    @Test
    public void testCarForSpringAndAutumn() {
        Month month = LocalDate.now().getMonth();
        if (month == Month.MARCH || month == Month.APRIL || month == Month.MAY ||
                month == Month.SEPTEMBER || month == Month.OCTOBER || month == Month.NOVEMBER) {
            assertEquals("Sedan", car.getCarType());
        }
    }

    @Test
    public void testHeadlightsTurnedOn() {
        boolean expectedHeadlights = LocalTime.now().isAfter(LocalTime.of(20, 0)) || LocalTime.now().isBefore(LocalTime.of(6, 0));
        assertEquals(expectedHeadlights, car.hasHeadlightsTurnedOn());
    }
}