package com.kodilla.mockito;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.kodilla.notification.Client;
import com.kodilla.notification.Notification;

public class NotificationService implements com.kodilla.mockito.homework.NotificationService {

    private Set<Client> clients = new HashSet<>();

    public void addSubscriber(Client client) {
        this.clients.add(client);
    }

    public void sendNotification(Notification notification) {
        this.clients.forEach(client -> client.receive(notification));
    }

    public void removeSubscriber(Client client) {
        this.clients.remove(client);
    }

    public void sendNotification(String mail, String message) {
        this.sendNotification("example@example.com", message);
    }
}
