package com.kodilla.mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.kodilla.mockito.homework.*;
import org.junit.jupiter.api.*;
import java.util.*;

public class WeatherAlertTestSuite {
    private WeatherAlertService weatherAlertService;
    private Inhabitant inhabitant;
    private Location location;

    @BeforeEach
    void setUp() {
        weatherAlertService = mock(WeatherAlertService.class);
        inhabitant = mock(Inhabitant.class);
        location = mock(Location.class);
    }

    @Test
    public void shouldAddInhabitantToLocation() {
        weatherAlertService.addInhabitantToLocation(inhabitant, location);
        when(weatherAlertService.getInhabitantsForLocation(location))
                .thenReturn(new HashSet<>(Collections.singletonList(inhabitant)));

        assertTrue(weatherAlertService.getInhabitantsForLocation(location).contains(inhabitant));
    }

    @Test
    public void shouldCancelSubscriptionFromLocation() {
        weatherAlertService.addInhabitantToLocation(inhabitant, location);
        weatherAlertService.cancelWeatherAlertsSubscriptionFromLocation(inhabitant, location);
        when(weatherAlertService.getInhabitantsForLocation(location)).thenReturn(new HashSet<>());

        assertFalse(weatherAlertService.getInhabitantsForLocation(location).contains(inhabitant));
    }

    @Test
    public void shouldCancelSubscriptionFromAllLocations() {
        Location anotherLocation = mock(Location.class);
        weatherAlertService.addInhabitantToLocation(inhabitant, location);
        weatherAlertService.addInhabitantToLocation(inhabitant, anotherLocation);
        weatherAlertService.cancelWeatherAlertsSubscriptionFromAllLocations(inhabitant);
        when(weatherAlertService.getInhabitantsForLocation(location)).thenReturn(new HashSet<>());
        when(weatherAlertService.getInhabitantsForLocation(anotherLocation)).thenReturn(new HashSet<>());

        assertFalse(weatherAlertService.getInhabitantsForLocation(location).contains(inhabitant));
        assertFalse(weatherAlertService.getInhabitantsForLocation(anotherLocation).contains(inhabitant));
    }

    @Test
    public void shouldSendWeatherAlertForSpecificLocation() {
        Set<Inhabitant> inhabitants = new HashSet<>(Collections.singletonList(inhabitant));
        when(weatherAlertService.getInhabitantsForLocation(location)).thenReturn(inhabitants);

        weatherAlertService.sendWeatherAlertForLocation(location);

        verify(inhabitant, times(1)).receiveWeatherAlert();
    }

    @Test
    public void shouldSendWeatherAlertToAllInhabitants() {
        Set<Inhabitant> allInhabitants = new HashSet<>(Collections.singletonList(inhabitant));
        when(weatherAlertService.getAllInhabitants()).thenReturn(allInhabitants);

        weatherAlertService.sendWeatherAlertForAll();

        verify(inhabitant, times(1)).receiveWeatherAlert();
    }

    @Test
    public void shouldRemoveLocation() {
        weatherAlertService.addLocation(location);
        weatherAlertService.removeLocation(location);
        when(weatherAlertService.getAllLocations()).thenReturn(new HashSet<>());

        assertFalse(weatherAlertService.getAllLocations().contains(location));
    }
}