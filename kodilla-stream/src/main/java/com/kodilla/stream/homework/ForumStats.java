package com.kodilla.stream.homework;

import com.kodilla.stream.User;
import com.kodilla.stream.UsersRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ForumStats {

    public static double getAveragePostsForUsersAbove40(List<User> users) {
        return users.stream()
                .filter(user -> user.getAge() >= 40)
                .mapToInt(User::getNumberOfPost)
                .average()
                .orElse(0);
    }

    public static double getAveragePostsForUsersBelow40(List<User> users) {
        return users.stream()
                .filter(user -> user.getAge() < 40)
                .mapToInt(User::getNumberOfPost)
                .average()
                .orElse(0);
    }

    public static void main(String[] args) {
        List<User> users = UsersRepository.getUsersList();

        double averagePostsAbove40 = getAveragePostsForUsersAbove40(users);
        double averagePostsBelow40 = getAveragePostsForUsersBelow40(users);

        System.out.println("Average number of posts shared by users aged 40 and over: " + averagePostsAbove40);
        System.out.println("Average number of posts shared by users younger than 40: " + averagePostsBelow40);
    }
}