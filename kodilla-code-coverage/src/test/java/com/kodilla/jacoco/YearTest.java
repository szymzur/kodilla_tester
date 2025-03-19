package com.kodilla.jacoco;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class YearTest {

    @Test
    public void shouldBeLeapYearIfDivisibleBy400() {
        Year year = new Year(1600);
        assertTrue(year.isLeap());
    }

    @Test
    public void shouldNotBeLeapYearIfDivisibleBy100ButNotBy400() {
        Year year = new Year(1700);
        assertFalse(year.isLeap());
    }

    @Test
    public void shouldBeLeapYearIfDivisibleBy4ButNotBy100() {
        Year year = new Year(2024);
        assertTrue(year.isLeap());
    }

    @Test
    public void shouldNotBeLeapYearIfNotDivisibleBy4() {
        Year year = new Year(2023);
        assertFalse(year.isLeap());
    }
}