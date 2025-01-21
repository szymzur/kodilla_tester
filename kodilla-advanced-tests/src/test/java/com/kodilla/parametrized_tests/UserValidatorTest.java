package com.kodilla.parametrized_tests;

import com.kodilla.parametrized_tests.homework.UserValidator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class UserValidatorTest {

    private final UserValidator validator = new UserValidator();

    @ParameterizedTest
    @CsvSource({
            "user123, true",
            "a-b_c, true",
            "ab, false",
            "a@b!c, false"
    })
    void shouldValidateUsername(String username, boolean expected) {
        boolean result = validator.validateUsername(username);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource({
            "example@example.com, true",
            "user.name@domain.com, true",
            "invalid-email@.com, false",
            "another!user@domain.com, false",
            "invalid@domain, false"
    })
    void shouldValidateEmail(String email, boolean expected) {
        boolean result = validator.validateEmail(email);
        assertEquals(expected, result);
    }
}