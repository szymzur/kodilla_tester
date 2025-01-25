package com.kodilla.mockito.homework;

public class WeatherAlertService {
    private UserRepository userRepository;
    private NotificationService notificationService;

    public WeatherAlertService(UserRepository userRepository, NotificationService notificationService) {
        this.userRepository = userRepository;
        this.notificationService = notificationService;
    }

    public void subscribeUser(String email, String location) {
        User user = userRepository.findUserByEmail(email).orElse(new User(email));
        user.subscribe(location);
        userRepository.saveUser(user);
    }

    public void unsubscribeUser(String email, String location) {
        userRepository.findUserByEmail(email).ifPresent(user -> {
            user.unsubscribe(location);
            if (user.getLocations().isEmpty()) {
                userRepository.deleteUser(email);
            } else {
                userRepository.saveUser(user);
            }
        });
    }

    public void unsubscribeUserFromAll(String email) {
        userRepository.findUserByEmail(email).ifPresent(user -> {
            user.unsubscribeAll();
            userRepository.deleteUser(email);
        });
    }

    public void sendAlertToLocation(String location, String message) {
        userRepository.findAllUsers().stream()
                .filter(user -> user.getLocations().contains(location))
                .forEach(user -> notificationService.sendNotification(user.getEmail(), message));
    }

    public void sendAlertToAll(String message) {
        userRepository.findAllUsers().forEach(user ->
                notificationService.sendNotification(user.getEmail(), message));
    }

    public void deleteLocation(String location) {
        userRepository.findAllUsers().forEach(user -> {
            user.unsubscribe(location);
            if (user.getLocations().isEmpty()) {
                userRepository.deleteUser(user.getEmail());
            } else {
                userRepository.saveUser(user);
            }
        });
    }
}