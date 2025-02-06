package com.kodilla.spring.basic.spring_dependency_injection;

import com.kodilla.spring.basic.spring_dependency_injection.homework.ShippingCenter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ShippingCenterTest {

    @Autowired
    private ShippingCenter shippingCenter;

    @Test
    public void testSendPackageSuccess() {
        String result = shippingCenter.sendPackage("Test Address", 10);
        assertEquals("Package delivered to: Test Address", result);
    }

    @Test
    public void testSendPackageFail() {
        String result = shippingCenter.sendPackage("Test Address", 40);
        assertEquals("Package not delivered to: Test Address", result);
    }
}