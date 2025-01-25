package com.kodilla.mockito.homework;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    Optional<User> findUserByEmail(String email);
    void saveUser(User user);
    void deleteUser(String email);
    List<User> findAllUsers();
}