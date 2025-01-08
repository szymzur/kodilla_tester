package com.kodilla.collections.adv.immutable.homework;

public class TaskTest {
    public static void main(String[] args) {
        Task task = new Task("Learning Java", 120);
        System.out.println("Task Title: " + task.title());
        System.out.println("Task Duration: " + task.duration());
        System.out.println("Task Details: " + task);
    }
}