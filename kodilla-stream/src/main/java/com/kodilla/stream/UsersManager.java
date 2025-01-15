package com.kodilla.stream;

import java.util.List;
import java.util.stream.Collectors;

public class UsersManager {
    public static void main(String[] args) {
        List<String> chemistGroupUsernames = filterChemistGroupUsernames();
        System.out.println("Chemist Group Usernames: " + chemistGroupUsernames);

        List<String> olderUsers = getUsersOlderThan(40);
        System.out.println("Users older than 40: " + olderUsers);

        List<String> activeUsers = getActiveUsers(10);
        System.out.println("Active users with more than 10 posts: " + activeUsers);
    }

    static List<String> filterChemistGroupUsernames() {
        List<String> usernames = UsersRepository.getUsersList()
                .stream()
                .filter(user -> user.getGroup().equals("Chemists"))
                .map(UsersManager::getUserName)
                .collect(Collectors.toList());

        return usernames;
    }

    public static String getUserName(User user) {
        return user.getUsername();
    }

    public static List<String> getUsersOlderThan(int age) {
        return UsersRepository.getUsersList()
                .stream()
                .filter(user -> user.getAge() > age)
                .map(UsersManager::getUserName)
                .collect(Collectors.toList());
    }

    public static List<String> getActiveUsers(int minPosts) {
        return UsersRepository.getUsersList()
                .stream()
                .filter(user -> user.getNumberOfPost() > minPosts)
                .map(UsersManager::getUserName)
                .collect(Collectors.toList());
    }
}