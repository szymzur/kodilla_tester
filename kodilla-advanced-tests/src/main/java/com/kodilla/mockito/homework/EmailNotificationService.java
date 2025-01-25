package com.kodilla.mockito.homework;

public class EmailNotificationService implements NotificationService {

    @Override
    public void sendNotification(String email, String message) {
        System.out.println("Sending notification to " + email + ": " + message);

    }
}

