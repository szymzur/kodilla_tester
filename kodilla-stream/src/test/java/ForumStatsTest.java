package com.kodilla.stream.homework;

import com.kodilla.stream.User;
import com.kodilla.stream.UsersRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ForumStatsTest {

    private List<User> users;

    @BeforeEach
    public void setUp() {
        users = UsersRepository.getUsersList();
    }

    @Test
    public void testGetAveragePostsForUsersAbove40() {
        double averagePosts = ForumStats.getAveragePostsForUsersAbove40(users);
        assertEquals(2.25, averagePosts);
    }

    @Test
    public void testGetAveragePostsForUsersBelow40() {
        double averagePosts = ForumStats.getAveragePostsForUsersBelow40(users);
        assertEquals(2382, averagePosts);
    }

    //Boundary Values Tests:
    @Test
    public void testGetAveragePostsForUsersAbove40WithNoUsers() {
        List<User> testUsers = List.of(
                new User("User1", 39, 10, "Group1"),
                new User("User2", 38, 20, "Group1")
        );
        double averagePosts = ForumStats.getAveragePostsForUsersAbove40(testUsers);
        assertEquals(0, averagePosts);
    }

    @Test
    public void testGetAveragePostsForUsersBelow40WithNoUsers() {
        List<User> testUsers = List.of(
                new User("User3", 40, 10, "Group2"),
                new User("User4", 41, 20, "Group2")
        );
        double averagePosts = ForumStats.getAveragePostsForUsersBelow40(testUsers);
        assertEquals(0, averagePosts);
    }
}