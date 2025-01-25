package com.kodilla.mockito;

import com.kodilla.mockito.homework.User;
import com.kodilla.mockito.homework.UserRepository;
import com.kodilla.mockito.homework.WeatherAlertService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class WeatherAlertServiceTest {
    private UserRepository userRepository;
    private NotificationService notificationService;
    private WeatherAlertService weatherAlertService;

    @BeforeEach
    void setUp() {
        userRepository = mock(UserRepository.class);
        notificationService = mock(NotificationService.class);
        weatherAlertService = new WeatherAlertService(userRepository, notificationService);
    }

    @Test
    void testSubscribeUser() {
        String email = "test@example.com";
        String location = "Location1";
        User user = new User(email);

        when(userRepository.findUserByEmail(email)).thenReturn(Optional.of(user));

        weatherAlertService.subscribeUser(email, location);

        verify(userRepository).saveUser(user);

        assertEquals(Set.of(location), user.getLocations());
    }

    @Test
    void testUnsubscribeUser() {
        String email = "test@example.com";
        String location = "Location1";
        User user = new User(email);
        user.subscribe(location);

        // Zwrot użytkownika w mocku userRepository
        when(userRepository.findUserByEmail(email)).thenReturn(Optional.of(user));

        // Rozsubskrybowanie użytkownika
        weatherAlertService.unsubscribeUser(email, location);

        // Weryfikacja, że userRepository.saveUser() został wywołany
        if(user.getLocations().isEmpty()) {
            verify(userRepository).deleteUser(email);
        } else {
            verify(userRepository).saveUser(user);
        }

        // Sprawdzenie, że lokalizacja jest usunięta z subskrypcji użytkownika
        assertFalse(user.getLocations().contains(location));
    }

    @Test
    void testUnsubscribeUserFromAll() {
        String email = "test@example.com";
        User user = new User(email);
        user.subscribe("Warszawa");
        user.subscribe("Kraków");

        when(userRepository.findUserByEmail(email)).thenReturn(Optional.of(user));

        weatherAlertService.unsubscribeUserFromAll(email);

        verify(userRepository, times(1)).deleteUser(email);
        assertTrue(user.getLocations().isEmpty());
    }

    @Test
    void testSendAlertToLocation() {
        String email = "test@example.com";
        String location = "Warszawa";
        String message = "Burza nadchodzi!";
        User user = new User(email);
        user.subscribe(location);

        when(userRepository.findAllUsers()).thenReturn(List.of(user));

        weatherAlertService.sendAlertToLocation(location, message);

        verify(notificationService, times(1)).sendNotification(email, message);
    }

    @Test
    void testSendAlertToAll() {
        String email1 = "test1@example.com";
        String email2 = "test2@example.com";
        String message = "Nowy regulamin!";

        User user1 = new User(email1);
        User user2 = new User(email2);

        when(userRepository.findAllUsers()).thenReturn(List.of(user1, user2));

        weatherAlertService.sendAlertToAll(message);

        verify(notificationService, times(1)).sendNotification(email1, message);
        verify(notificationService, times(1)).sendNotification(email2, message);
    }
}