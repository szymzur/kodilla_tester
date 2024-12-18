package com.kodilla.basic_assertion;

public class Application {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int a = 5;
        int b = 8;
        int sumResult = calculator.sum(a, b);
        int subResult = calculator.sub(a, b);
        int squareResult = calculator.square(a);
        boolean correct =
                ResultChecker.assertEquals(13, sumResult) &&
                ResultChecker.assertEquals(-3, subResult) &&
                ResultChecker.assertEquals(24, squareResult);
        if (correct) {
            System.out.println("The method is working correctly for integers " + a + " and " + b);
        } else {
            System.out.println("The method is not working correctly for integers " + a + " i " + b);
        }
    }
}
