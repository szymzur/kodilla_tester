package com.kodilla.optional.homework;

import java.util.List;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        Teacher teacher1 = new Teacher("Alfred Kijowski");
        Teacher teacher2 = new Teacher("Miroslaw Gawedzki");

        students.add(new Student("Marcelina Brucka", teacher1));
        students.add(new Student("Piotr Drabowicz", teacher2));
        students.add(new Student("Andrzej Roj", null));
        students.add(new Student("Anna Kostka", teacher1));
        students.add(new Student("Jerzy Harnik", null));

        for (Student student : students) {
            String teacherName = student.getTeacher().map(Teacher::getName).orElse("<undefined>");
            System.out.println("Student: " + student.getName() + ", teacher: " + teacherName);
        }
    }
}