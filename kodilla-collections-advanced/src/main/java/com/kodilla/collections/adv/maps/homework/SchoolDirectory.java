package com.kodilla.collections.adv.maps.homework;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SchoolDirectory {
    public static void main(String[] args) {
        Map<Principal, School> schoolDirectory = new HashMap<>();

        Principal principal1 = new Principal("Anna", "Kowalska");
        Principal principal2 = new Principal("Jan", "Nowak");
        Principal principal3 = new Principal("Tomasz", "Staniszewski");

        School school1 = new School("Primary School nr 1", Arrays.asList(25, 28, 30, 27, 26));
        School school2 = new School("Primary School nr 2", Arrays.asList(22, 25, 29, 30, 31));
        School school3 = new School("Primary School nr 3", Arrays.asList(24, 27, 26, 28, 25));

        schoolDirectory.put(principal1, school1);
        schoolDirectory.put(principal2, school2);
        schoolDirectory.put(principal3, school3);

        for (Map.Entry<Principal, School> entry : schoolDirectory.entrySet()) {
            System.out.println("Principal: " + entry.getKey() + ", School: " + entry.getValue() + ", Total number of students: " + entry.getValue().getTotalStudents());
        }
    }
}