package com.kodilla.exception.homework;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class WarehouseTest {
    private Warehouse warehouse;

    @BeforeEach
    public void setUp() {
        warehouse = new Warehouse();
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
        Order order = new Order("456");
        warehouse.addOrder(order);

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
            warehouse.getOrder("999");
        });
    }

    @Test
    public void testGetOrderWithMultipleOrders() {
        Order order1 = new Order("111");
        Order order2 = new Order("222");
        Order order3 = new Order("333");

        warehouse.addOrder(order1);
        warehouse.addOrder(order2);
        warehouse.addOrder(order3);

        try {
            Order foundOrder = warehouse.getOrder("222");
            assertEquals("222", foundOrder.getNumber());
        } catch (OrderDoesntExistException e) {
            fail("Order should exist in the warehouse.");
        }
    }
}