package com.kodilla.abstracts.homework;

public class AppJob {
    public static void main(String[] args) {
        Job teacher = new Teacher(1500);
        Job architect = new Architect(3400);
        Job lawyer = new Lawyer(4200);

        Person person1 = new Person("Steven", 27, teacher);
        Person person2 = new Person("Jenny", 33, architect);
        Person person3 = new Person("Jordan", 45, lawyer);

        person1.displayResponsibilities();
        person2.displayResponsibilities();
        person3.displayResponsibilities();
    }
}
