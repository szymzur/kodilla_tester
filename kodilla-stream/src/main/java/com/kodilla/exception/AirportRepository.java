package com.kodilla.exception;

import java.util.HashMap;
import java.util.Map;

public class AirportRepository {
    private Map<String, Boolean> airports;

    public AirportRepository() {
        airports = new HashMap<>();
        airports.put("Miami", true);
        airports.put("Malta", true);
        airports.put("Las Palmas", false);
        airports.put("Warsaw", true);
    }

    public boolean isAirportInUse(String airport) throws AirportNotFoundException {
        if (!airports.containsKey(airport)) {
            throw new AirportNotFoundException("Airport " + airport + " not found.");
        }
        return airports.get(airport);
    }
}