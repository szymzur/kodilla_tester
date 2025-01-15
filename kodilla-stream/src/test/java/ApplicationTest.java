package com.kodilla.optional.homework;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

public class ApplicationTest {

    @Test
    public void testStudentWithTeacher() {
        Teacher teacher = new Teacher("Alfred Kijowski");
        Student student = new Student("Marcelina Brucka", teacher);
        assertEquals("Alfred Kijowski", student.getTeacher().map(Teacher::getName).orElse("<undefined>"));
    }

    @Test
    public void testStudentWithoutTeacher() {
        Student student = new Student("Andrzej Roj",null);
        assertEquals("<undefined>", student.getTeacher().map(Teacher::getName).orElse("<undefined>"));
    }

    @Test
    public void testStudentList() {
        Teacher teacher1 = new Teacher("Alfred Kijowski");
        Teacher teacher2 = new Teacher("Miroslaw Gawedzki");

        List<Student> students = new ArrayList<>();
        students.add(new Student("Marcelina Brucka", teacher1));
        students.add(new Student("Piotr Drabowicz", teacher2));
        students.add(new Student("Andrzej Roj", null));
        students.add(new Student("Anna Kostka", teacher1));
        students.add(new Student("Jerzy Harnik", null));

        List<String> expectedOutput = List.of(
                "student: Marcelina Brucka, teacher: Alfred Kijowski",
                "student: Piotr Drabowicz, teacher: Miroslaw Gawedzki",
                "student: Andrzej Roj, teacher: <undefined>",
                "student: Anna Kostka, teacher: Alfred Kijowski",
                "student Jerzy Harnik, teacher: <undefined>"
        );

        List<String> actualOutput = new ArrayList<>();
        for (Student student : students) {
            String teacherName = student.getTeacher().map(Teacher::getName).orElse("<undefined");
        }

        assertEquals(expectedOutput);
    }
}
