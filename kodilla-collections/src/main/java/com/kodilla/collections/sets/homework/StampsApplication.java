package com.kodilla.collections.sets.homework;

import java.util.HashSet;
import java.util.Set;

public class StampsApplication {
    public static void main(String[] args) {
        Set<Stamp> stamps = new HashSet<>();

        stamps.add(new Stamp("Butterfly", 3.0, 2.5, true));
        stamps.add(new Stamp("Bird", 4.0, 3.0, false));
        stamps.add(new Stamp("Flower", 2.5, 2.5, true));
        stamps.add(new Stamp("Butterfly", 3.0, 2.5, true));

        System.out.println("Stamps collection size: " + stamps.size());
        for (Stamp stamp : stamps) {
            System.out.println(stamp);
        }
    }
}