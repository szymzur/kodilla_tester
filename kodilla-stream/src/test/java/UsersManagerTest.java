package com.kodilla.stream;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UsersManagerTest {

    @Test
    public void testFilterChemistGroupUsernames() {
        List<User> usersList = UsersRepository.getUsersList();
        List<String> chemistGroupUsernames = UsersManager.filterChemistGroupUsernames();
        List<String> expectedUsernames = List.of("Walter White", "Gale Boetticher");
        assertEquals(expectedUsernames, chemistGroupUsernames);
    }

    @Test
    public void testGetUsersOlderThan() {
        int ageThreshold = 40;
        List<String> olderUsers = UsersManager.getUsersOlderThan(ageThreshold);

        // Sprawdzam, czy wszystkie zwrócone elementy mają wiek większy od podanej wartości
        for (String username : olderUsers) {
            User user = UsersRepository.getUsersList().stream()
                    .filter(u -> u.getUsername().equals(username))
                    .findFirst()
                    .orElse(null);
            assertTrue(user != null && user.getAge() > ageThreshold, "User's age is not greater than " + ageThreshold);
        }
    }

    @Test
    public void testGetActiveUsers() {
        int minPosts = 10;
        List<String> activeUsers = UsersManager.getActiveUsers(minPosts);

        // Sprawdzam, czy wszystkie zwrócone elementy mają liczbę postów większą od podanej wartości
        for (String username : activeUsers) {
            User user = UsersRepository.getUsersList().stream()
                    .filter(u -> u.getUsername().equals(username))
                    .findFirst()
                    .orElse(null);
            assertTrue(user != null && user.getNumberOfPost() > minPosts, "User's number of posts is not greater than " + minPosts);
        }
    }
}