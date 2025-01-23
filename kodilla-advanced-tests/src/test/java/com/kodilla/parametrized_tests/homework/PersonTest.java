package com.kodilla.parametrized_tests.homework;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonTest {

    @ParameterizedTest
    @MethodSource("bmiTestData")
    public void shouldCalculateBMI(double heightInMeters, double weightInKilogram, String expectedBMICategory) {
        Person person = new Person(heightInMeters, weightInKilogram);

        String bmiCategory = person.getBMI();

        assertEquals(expectedBMICategory, bmiCategory);
    }

    private static Stream<Arguments> bmiTestData() {
        return Stream.of(
                Arguments.of(1.75, 50.0, "Very severely underweight"),
                Arguments.of(1.75, 55.0, "Severely underweight"),
                Arguments.of(1.75, 60.0, "Underweight"),
                Arguments.of(1.75, 70.0, "Normal (healthy weight)"),
                Arguments.of(1.75, 80.0, "Overweight"),
                Arguments.of(1.75, 90.0, "Obese Class I (Moderately obese)"),
                Arguments.of(1.75, 100.0, "Obese Class II (Severely obese)"),
                Arguments.of(1.75, 110.0, "Obese Class III (Very severely obese)"),
                Arguments.of(1.75, 120.0, "Obese Class IV (Morbidly Obese)"),
                Arguments.of(1.75, 140.0, "Obese Class V (Super Obese)"),
                Arguments.of(1.75, 160.0, "Obese Class VI (Hyper Obese)")
        );
    }
}