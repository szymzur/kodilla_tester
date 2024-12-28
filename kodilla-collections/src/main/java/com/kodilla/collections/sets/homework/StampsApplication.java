package com.kodilla.collections.sets.homework;

import java.util.HashSet;
import java.util.Set;

public class StampsApplication {
    public static void main(String[] args) {
        Set<Stamp> stamps = new HashSet<>();

        Stamp stamp1 = new Stamp("Butterfly", 3.0, 2.5, true);
        Stamp stamp2 = new Stamp("Bird", 4.0, 3.0, false);
        Stamp stamp3 = new Stamp("Flower", 2.5, 2.5, true);
        Stamp stamp4 = new Stamp("Butterfly", 3.0, 2.5, true);

        stamps.add(stamp1);
        stamps.add(stamp2);
        stamps.add(stamp3);
        stamps.add(stamp4);

        System.out.println("Stamps collection size: " + stamps.size());
        for (Stamp stamp : stamps) {
            System.out.println(stamp);
        }
    }
}