package com.paintshop;

import com.paintshop.models.Customer;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class CustomerTest {
    @Test
    public void glossy_ok() {
        boolean[] batch = new boolean[] {false, true};
        Customer customer = new Customer(batch.length);

        customer.setGlossy(0);
        assertTrue(customer.isSolutionSuitable(batch));
    }

    @Test
    public void matte_ok() {
        boolean[] batch = new boolean[] {false, true};
        Customer customer = new Customer(batch.length);

        customer.setMatte(1);
        assertTrue(customer.isSolutionSuitable(batch));
    }

    @Test
    public void glossy_matte_ok() {
        boolean[] batch = new boolean[] {false, true};
        Customer customer = new Customer(batch.length);

        customer.setGlossy(0);
        customer.setMatte(1);
        assertTrue(customer.isSolutionSuitable(batch));
    }

    @Test
    public void matte_glossy_fail() {
        boolean[] secondMatte = new boolean[] {false, true};
        Customer customer = new Customer(secondMatte.length);

        customer.setMatte(0);
        customer.setGlossy(1);
        assertFalse(customer.isSolutionSuitable(secondMatte));
    }
} 
