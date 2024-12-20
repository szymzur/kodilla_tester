package com.kodilla.basic_assertion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTestSquare {

    @Test
    public void testSquare() {
        Calculator calculator = new Calculator();
        int a = 5;
        double squareResult = calculator.square(a);
        assertEquals(25, squareResult, 1e-9);
    }
}