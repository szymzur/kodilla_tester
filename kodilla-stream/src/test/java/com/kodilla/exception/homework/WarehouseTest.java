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
        Order order1 = new Order("111");
        Order order2 = new Order("222");
        Order order3 = new Order("333");
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
            Order foundOrder = warehouse.getOrder("333");
            assertEquals("333", foundOrder.getNumber());
        } catch (OrderDoesntExistException e) {
            fail("Order should exist in the warehouse.");
        }
    }

    @Test
    public void testGetOrderWhenOrderDoesNotExist() {
        assertThrows(OrderDoesntExistException.class, () -> {
            warehouse.getOrder("999");
        });
    }

    @Test
    public void testGetOrderWithMultipleOrders() {
        try {
            Order foundOrder = warehouse.getOrder("222");
            assertEquals("222", foundOrder.getNumber());
        } catch (OrderDoesntExistException e) {
            fail("Order should exist in the warehouse.");
        }
    }
}