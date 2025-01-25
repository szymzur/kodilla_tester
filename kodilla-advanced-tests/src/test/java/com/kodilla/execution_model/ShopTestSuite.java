package com.kodilla.execution_model;

import com.kodilla.execution_model.homework.Order;
import com.kodilla.execution_model.homework.Shop;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ShopTestSuite {
    private Shop shop;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @BeforeEach
    public void setup() throws ParseException {
        shop = new Shop();
        shop.addOrder(new Order(100.0, dateFormat.parse("2025-01-01"), "user1"));
        shop.addOrder(new Order(200.0, dateFormat.parse("2025-01-15"), "user2"));
        shop.addOrder(new Order(300.0, dateFormat.parse("2025-02-01"), "user3"));
        shop.addOrder(new Order(400.0, dateFormat.parse("2025-02-15"), "user4"));
    }

    @Test
    public void testAddOrder() throws ParseException {
        shop.addOrder(new Order(500.0, dateFormat.parse("2025-03-01"), "user5"));
        assertEquals(5, shop.getOrderCount());
    }

    @Test
    public void testGetOrdersBetweenDates() throws ParseException {
        Date startDate = dateFormat.parse("2025-01-01");
        Date endDate = dateFormat.parse("2025-01-31");
        List<Order> orders = shop.getOrdersBetweenDates(startDate, endDate);
        assertEquals(2, orders.size());
    }

    @Test
    public void testGetOrdersByValueRange() {
        List<Order> orders = shop.getOrdersByValueRange(100.0, 300.0);
        assertEquals(3, orders.size());
    }

    @Test
    public void testGetOrderCount() {
        assertEquals(4, shop.getOrderCount());
    }

    @Test
    public void testGetTotalOrderValue() {
        assertEquals(1000.0, shop.getTotalOrderValue());
    }
}