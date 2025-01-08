package com.kodilla.collections.adv.maps.homework;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SchoolDirectory {
    public static void main(String[] args) {
        Map<Principal, School> schoolDirectory = new HashMap<>();

        schoolDirectory.put(new Principal("Anna", "Kowalska"), new School("Primary School nr 1", Arrays.asList(25, 28, 30, 27, 26)));
        schoolDirectory.put(new Principal("Jan", "Nowak"), new School("Primary School nr 2", Arrays.asList(22, 25, 29, 30, 31)));
        schoolDirectory.put(new Principal("Tomasz", "Staniszewski"), new School("Primary School nr 3", Arrays.asList(24, 27, 26, 28, 25)));

        for (Map.Entry<Principal, School> entry : schoolDirectory.entrySet()) {
            System.out.println("Principal: " + entry.getKey() + ", School: " + entry.getValue() + ", Total number of students: " + entry.getValue().getTotalStudents());
        }
    }
}