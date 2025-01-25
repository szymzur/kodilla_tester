package com.kodilla.execution_model.homework;

import java.util.*;
import java.util.stream.Collectors;

public class Shop {
    private Set<Order> orders = new HashSet<>();

    // Dodanie nowego zamówienia
    public void addOrder(Order order) {
        orders.add(order);
    }

    // Zwrócenie listy zamówień z zakresu dwóch dat
    public List<Order> getOrdersBetweenDates(Date startDate, Date endDate) {
        return orders.stream()
                .filter(order -> !order.getOrderDate().before(startDate) && !order.getOrderDate().after(endDate))
                .collect(Collectors.toList());
    }

    // Pobranie zamówień na podstawie przekazanego zakresu wartości
    public List<Order> getOrdersByValueRange(double minValue, double maxValue) {
        return orders.stream()
                .filter(order -> order.getOrderValue() >= minValue && order.getOrderValue() <= maxValue)
                .collect(Collectors.toList());
    }

    // Zwrócenie liczby zamówień
    public int getOrderCount() {
        return orders.size();
    }

    // Zsumowanie wartości wszystkich zamówień
    public double getTotalOrderValue() {
        return orders.stream()
                .mapToDouble(Order::getOrderValue)
                .sum();
    }
}