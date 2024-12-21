package com.kodilla.basic_assertion;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTestSuite {
    static Calculator calculator;
    static int a;
    static int b;

    @BeforeAll
    public static void setUp() {
        calculator = new Calculator();
        a = 5;
        b = 8;
    }

    @Test
    public void testSum() {
        int sumResult = calculator.sum(a, b);
        assertEquals(13, sumResult);
    }

    @Test
    public void testSub() {
        int subResult = calculator.sub(a, b);
        assertEquals(-3, subResult);
    }

    @Test
    public void testSquare() {
        double squareResult = calculator.square(a);
        assertEquals(25, squareResult, 1e-9);
    }
}