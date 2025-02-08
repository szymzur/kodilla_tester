package com.kodilla.spring.basic.spring_scopes;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
public class ClockTest {

    @Autowired
    private ApplicationContext context;

    @Test
    public void shouldCreateDifferentClocks() {
        Clock firstBean = context.getBean(Clock.class);
        Clock secondBean = context.getBean(Clock.class);
        Clock thirdBean = context.getBean(Clock.class);

        System.out.println("Clock 1 time: " + firstBean.getTime());
        System.out.println("Clock 2 time: " + secondBean.getTime());
        System.out.println("Clock 3 time: " + thirdBean.getTime());

        assertNotEquals(firstBean, secondBean);
        assertNotEquals(secondBean, thirdBean);
        assertNotEquals(firstBean, thirdBean);
    }
}