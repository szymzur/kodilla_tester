package com.kodilla.parametrized_tests.homework;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
}