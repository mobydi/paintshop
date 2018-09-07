package com.paintshop.models;

import java.util.Arrays;


public class TestCase {
    private final int numColors;
    private final Customer[] customers;

    public TestCase(int numColors, Customer[] customers) {
        this.numColors = numColors;
        this.customers = customers;
    }

    public int getNumColors() {
        return numColors;
    }

    public Customer[] getCustomers() {
        return customers;
    }

    @Override
    public String toString() {
        return "numColors=" + numColors +
                "customers[]=" + Arrays.toString(customers);
    }
}
