package com.paintshop;

import com.paintshop.models.Customer;
import com.paintshop.models.TestCase;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.Scanner;


class Parser {

    static TestCase[] parse(InputStream inputStream) throws FileNotFoundException, ParseException {
        try (Scanner scan = new Scanner(inputStream)) {
            if (!scan.hasNextLine() || !scan.hasNextInt())
                throw new ParseException("The number of test cases is not defined", 0);
            int numTestCases = scan.nextInt();

            TestCase[] testCases = new TestCase[numTestCases];
            for (int i = 0; i < numTestCases; i++) {
                testCases[i] = parseTestCase(scan, i);
            }
            return testCases;
        }
    }

    private static TestCase parseTestCase(Scanner scan, int index) throws ParseException {
        if (!scan.hasNextLine() || !scan.hasNextInt())
            throw new ParseException("The number of colors is not defined", index+1);
        Integer numColors = scan.nextInt();

        if (!scan.hasNextLine() || !scan.hasNextInt())
            throw new ParseException("The number of customers is not defined", index+1);
        Integer numCustomers = scan.nextInt();

        Customer[] customers = new Customer[numCustomers];
        for (int c = 0; c < numCustomers; c++) {
            customers[c] = parseCustomer(scan, numColors, c);
        }
        return new TestCase(numColors, customers);
    }

    private static Customer parseCustomer(Scanner scan, int maxColor, int index) throws ParseException {
        if (!scan.hasNextInt())
            throw new ParseException("The number of paint types the customer likes is not defined", index);
        Integer numPaint = scan.nextInt();

        Customer customer = new Customer(maxColor);
        for (int p = 0; p < numPaint; p++) {
            if (!scan.hasNextInt())
                throw new ParseException("The number of paint is not defined", index);
            Integer paint = scan.nextInt();
            if (paint > maxColor)
                throw new ParseException("The paint is max that defined", index);

            if (!scan.hasNextInt())
                throw new ParseException("The number of color is not defined", index);
            Integer color = scan.nextInt();
            if (color > maxColor)
                throw new ParseException("The color is not that 0 or 1", index);

            if (color == 0)
                customer.setGlossy(paint - 1);
            if (color == 1)
                customer.setMatte(paint - 1);
        }
        return customer;
    }
}
