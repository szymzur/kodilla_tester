package com.kodilla.parametrized_tests.homework;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.HashSet;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class GamblingMachineTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/testdata.csv")
    public void testInvalidSize(String csvRow) {
        Set<Integer> userNumbers = Stream.of(csvRow.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toSet());

        Set<Integer> invalidSizeNumbers = userNumbers.stream().limit(3).collect(Collectors.toSet());

        GamblingMachine machine = new GamblingMachine();

        assertThrows(InvalidNumbersException.class, () -> machine.howManyWins(invalidSizeNumbers));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/testdata.csv")
    public void testOutOfScopeNumbers(String csvRow) {
        Set<Integer> userNumbers = Stream.of(csvRow.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toSet());

        Set<Integer> outOfScopeNumbers = userNumbers.stream().map(num -> num + 50).collect(Collectors.toSet());

        GamblingMachine machine = new GamblingMachine();

        assertThrows(InvalidNumbersException.class, () -> machine.howManyWins(outOfScopeNumbers));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6"}) // przykład jednej linii z pliku CSV
    public void testAnyWinsPossible(String csvRow) {
        Set<Integer> userNumbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));

        GamblingMachine machine = new GamblingMachine();
        boolean hasWin = false;

        for (int i = 0; i < 1000; i++) {
            try {
                int wins = machine.howManyWins(userNumbers);
                if (wins > 0) {
                    hasWin = true;
                    break;
                }
            } catch (InvalidNumbersException e) {
                throw new RuntimeException(e);
            }
        }

        assertTrue(hasWin, "Expected to find at least one win in 1000 attempts, but got none.");
    }
}