package com.kodilla.parametrized_tests.homework;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GamblingMachineTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/testdata.csv", numLinesToSkip = 1)
    public void testHowManyWinsWithCsvFile(String csvRow, int expectedWinCount) throws InvalidNumbersException {
        Set<Integer> userNumbers = Stream.of(csvRow.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toSet());

        GamblingMachine machine = new GamblingMachine();
        int winCount = machine.howManyWins(userNumbers);

        assertEquals(expectedWinCount, winCount);
    }
}