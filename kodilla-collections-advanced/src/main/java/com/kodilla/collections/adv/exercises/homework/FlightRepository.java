package com.kodilla.collections.adv.exercises.homework;

import java.util.ArrayList;
import java.util.List;

public class FlightRepository {
    public static List<Flight> getFlightTable() {
        List<Flight> flights = new ArrayList<>();
        flights.add(new Flight("La Paz", "Santa Cruz"));
        flights.add(new Flight("La Paz", "Lima"));
        flights.add(new Flight("La Paz", "Bogota"));
        flights.add(new Flight("Lima", "La Paz"));
        flights.add(new Flight("Santa Cruz", "La Paz"));
        return flights;
    }
}