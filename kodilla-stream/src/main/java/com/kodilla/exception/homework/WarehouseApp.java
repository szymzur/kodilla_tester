package com.kodilla.exception.homework;

public class WarehouseApp {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();

        // Adding orders to the warehouse
        warehouse.addOrder(new Order("123"));
        warehouse.addOrder(new Order("456"));
        warehouse.addOrder(new Order("789"));

        // Attempt to find an existing order
        try {
            Order order = warehouse.getOrder("456");
            System.out.println("The order which was found: " + order.getNumber());
        } catch (OrderDoesntExistException e) {
            System.out.println(e.getMessage());
        }

        // Attempt to search for a non-existent order
        try {
            Order order = warehouse.getOrder("789");
            System.out.println("The order which was found: " + order.getNumber());
        } catch (OrderDoesntExistException e) {
            System.out.println(e.getMessage());
        }
    }
}