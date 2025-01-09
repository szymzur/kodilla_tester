package com.kodilla.collections.adv.exercises.dictionary;

import com.kodilla.collections.adv.exercises.homework.Flight;
import com.kodilla.collections.adv.exercises.homework.FlightFinder;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FlightFinderTest {

    @Test
    public void testFindFlightsFrom() {
        // given
        FlightFinder flightFinder = new FlightFinder();
        String departure = "La Paz";
        // when
        List<Flight> flights = flightFinder.findFlightsFrom(departure);
        // then
        assertEquals(3, flights.size());
        assertEquals("La Paz", flights.get(0).getDeparture());
        assertEquals("Santa Cruz", flights.get(0).getArrival());
    }

    @Test
    public void testFindFlightsTo() {
        // given
        FlightFinder flightFinder = new FlightFinder();
        String arrival = "La Paz";
        // when
        List<Flight> flights = flightFinder.findFlightsTo(arrival);
        // then
        assertEquals(2, flights.size());
        assertEquals("Lima", flights.get(0).getDeparture());
        assertEquals("La Paz", flights.get(0).getArrival());
    }

    @Test
    public void testFindFlightsFromNoMatches() {
        // given
        FlightFinder flightFinder = new FlightFinder();
        String departure = "Santiago";
        // when
        List<Flight> flights = flightFinder.findFlightsFrom(departure);
        // then
        assertEquals(0, flights.size());
    }

    @Test
    public void testFindFlightsToNoMatches() {
        // given
        FlightFinder flightFinder = new FlightFinder();
        String arrival = "Sucre";
        // when
        List<Flight> flights = flightFinder.findFlightsTo(arrival);
        // then
        assertEquals(0, flights.size());
    }
}