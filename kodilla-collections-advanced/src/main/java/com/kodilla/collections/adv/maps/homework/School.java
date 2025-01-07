package com.kodilla.collections.adv.maps.homework;

import java.util.List;

public class School {
    private String name;
    private List<Integer> studentsPerClass;

    public School(String name, List<Integer> studentsPerClass) {
        this.name = name;
        this.studentsPerClass = studentsPerClass;
    }

    public int getTotalStudents() {
        int total = 0;
        for (int students : studentsPerClass) {
            total += students;
        }
        return total;
    }

    @Override
    public String toString() {
        return name;
    }
}