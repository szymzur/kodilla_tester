package com.kodilla.jacoco;

public class Year {

    private static final int FOUR = 4;
    private static final int ONE_HUNDRED = 100;
    private static final int FOUR_HUNDRED = 400;

    private final int year;

    public Year(int year) {
        this.year = year;
    }

    public boolean isLeap() {
        if (year % FOUR_HUNDRED == 0) {
            return true;
        }
        if (year % ONE_HUNDRED == 0) {
            return false;
        }
        return year % FOUR == 0;
    }
}