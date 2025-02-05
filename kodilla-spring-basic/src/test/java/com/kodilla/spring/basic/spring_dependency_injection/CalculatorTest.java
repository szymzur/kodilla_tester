package com.kodilla.spring.basic.spring_dependency_injection;

import com.kodilla.spring.basic.spring_dependency_injection.homework.Calculator;
import com.kodilla.spring.basic.spring_dependency_injection.homework.Display;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        ApplicationContext context = new AnnotationConfigApplicationContext(Display.class, Calculator.class);
        calculator = context.getBean(Calculator.class);
    }

    @Test
    void testAdd() {
        double result = calculator.add(5, 3);
        Assertions.assertEquals(8, result);
    }

    @Test
    void testSubtract() {
        double result = calculator.subtract(5, 3);
        Assertions.assertEquals(2, result);
    }

    @Test
    void testMultiply() {
        double result = calculator.multiply(5, 3);
        Assertions.assertEquals(15, result);
    }

    @Test
    void testDivide() {
        double result = calculator.divide(6, 3);
        Assertions.assertEquals(2, result);
    }

    @Test
    void testDivideByZero() {
        double result = calculator.divide(6, 0);
        Assertions.assertEquals(Double.NaN, result);
    }
}