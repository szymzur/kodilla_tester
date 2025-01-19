package com.kodilla.exception.homework;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class WarehouseTest {
    private static Warehouse warehouse;

    @BeforeAll
    public static void setUp() {
        warehouse = new Warehouse();
        Order order1 = new Order("123");
        Order order2 = new Order("456");
        Order order3 = new Order("789");
        warehouse.addOrder(order1);
        warehouse.addOrder(order2);
        warehouse.addOrder(order3);
    }

    @Test
    public void testAddOrder() {
        Order order = new Order("123");
        warehouse.addOrder(order);

        try {
            Order foundOrder = warehouse.getOrder("123");
            assertEquals(order.getNumber(), foundOrder.getNumber());
        } catch (OrderDoesntExistException e) {
            fail("Order should exist in the warehouse.");
        }
    }

    @Test
    public void testGetOrderWhenOrderExists() {
        try {
            Order foundOrder = warehouse.getOrder("456");
            assertEquals("456", foundOrder.getNumber());
        } catch (OrderDoesntExistException e) {
            fail("Order should exist in the warehouse.");
        }
    }

    @Test
    public void testGetOrderWhenOrderDoesNotExist() {
        assertThrows(OrderDoesntExistException.class, () -> {
            warehouse.getOrder("321");
        });
    }

    @Test
    public void testGetOrderWithMultipleOrders() {
        try {
            Order foundOrder = warehouse.getOrder("789");
            assertEquals("789", foundOrder.getNumber());
        } catch (OrderDoesntExistException e) {
            fail("Order should exist in the warehouse.");
        }
    }
}