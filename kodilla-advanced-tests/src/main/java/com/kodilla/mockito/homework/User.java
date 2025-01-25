package com.kodilla.mockito.homework;

import java.util.HashSet;
import java.util.Set;

public class User {
    private String email;
    private Set<String> locations;

    public User(String email) {
        this.email = email;
        this.locations = new HashSet<>();
    }

    public String getEmail() {
        return email;
    }

    public Set<String> getLocations() {
        return locations;
    }

    public void subscribe(String location) {
        locations.add(location);
    }

    public void unsubscribe(String location) {
        locations.remove(location);
    }

    public void unsubscribeAll() {
        locations.clear();
    }
}