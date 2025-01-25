package com.kodilla.mockito.homework;

import java.util.*;
import java.util.stream.Collectors;

public class WeatherAlertService {

    private Set<Location> locations = new HashSet<>();
    private Map<Location, Set<Inhabitant>> locationInhabitants = new HashMap<>();

    // Dodajemy użytkownika do lokalizacji
    public void addInhabitantToLocation(Inhabitant inhabitant, Location location) {
        locationInhabitants
                .computeIfAbsent(location, k -> new HashSet<>())
                .add(inhabitant);
    }

    // Anulujemy subskrypcję dla użytkownika z danej lokalizacji
    public void cancelWeatherAlertsSubscriptionFromLocation(Inhabitant inhabitant, Location location) {
        Set<Inhabitant> inhabitants = locationInhabitants.get(location);
        if (inhabitants != null) {
            inhabitants.remove(inhabitant);
        }
    }

    // Anulujemy subskrypcję dla użytkownika ze wszystkich lokalizacji
    public void cancelWeatherAlertsSubscriptionFromAllLocations(Inhabitant inhabitant) {
        locationInhabitants.values().forEach(inhabitants -> inhabitants.remove(inhabitant));
    }

    // Wysyłamy powiadomienie dla danej lokalizacji
    public void sendWeatherAlertForLocation(Location location) {
        Set<Inhabitant> inhabitants = locationInhabitants.get(location);
        if (inhabitants != null) {
            inhabitants.forEach(Inhabitant::receiveWeatherAlert);
        }
    }

    // Wysyłamy powiadomienie dla wszystkich
    public void sendWeatherAlertForAll() {
        locationInhabitants.values().stream()
                .flatMap(Set::stream)
                .forEach(Inhabitant::receiveWeatherAlert);
    }

    // Dodajemy nową lokalizację
    public void addLocation(Location location) {
        locations.add(location);
    }

    // Usuwamy lokalizację
    public void removeLocation(Location location) {
        locations.remove(location);
        locationInhabitants.remove(location);
    }

    // Pobieramy mieszkańców dla danej lokalizacji
    public Set<Inhabitant> getInhabitantsForLocation(Location location) {
        return locationInhabitants.getOrDefault(location, new HashSet<>());
    }

    // Pobieramy wszystkie lokalizacje
    public Set<Location> getAllLocations() {
        return locations;
    }

    // Pobieramy wszystkich mieszkańców
    public Set<Inhabitant> getAllInhabitants() {
        return locationInhabitants.values().stream()
                .flatMap(Set::stream)
                .collect(Collectors.toSet());
    }
}