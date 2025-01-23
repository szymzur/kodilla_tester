package com.kodilla.parametrized_tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class StringValidatorTestSuite {

    private StringValidator validator = new StringValidator();

    @Test
    public void shouldReturnFalseIfStringIsNotEmpty() {
        assertFalse(validator.isBlank("test"));
    }

//    @Test
//    public void shouldReturnTrueIfStringIsNotEmpty () {
//        assertTrue(validator.isBlank(""));
//    }
//
//    @Test
//    public void shouldReturTrueIfStringHasOnlySpaces() {
//        assertTrue(validator.isBlank("    "));
//    }

//    @ParameterizedTest
//    @ValueSource(strings = {"", "   "})
//    public void shouldReturnTrueIfStringIsEmpty(String text) {
//        assertTrue(validator.isBlank(text));
//    }

    @Test
    public void shouldReturnTrueIfStringIsNull() {
        assertTrue(validator.isBlank(null));
    }

    @ParameterizedTest
    @NullAndEmptySource
    public void shouldReturnTrueIfStringIsEmpty(String text) {
        System.out.println("|" + text + "|");
        assertTrue(validator.isBlank(text));
    }
}
