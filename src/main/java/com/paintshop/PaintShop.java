package com.paintshop;

import com.paintshop.models.TestCase;
import com.paintshop.models.TestResult;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;


public class PaintShop {
    public static void main(String[] args) {
        try {
            if (args.length == 0 || Objects.equals(args[0], "-h") || Objects.equals(args[0], "--help")) {
                System.out.println("PaintShop problem solver.");
                System.out.println("Usage: java -jar <jar name> testcases.file");
                System.exit(0);
                return;
            }
            if (args.length > 0) {
                System.setIn(new FileInputStream(args[0]));
            }

            PaintShop paintShop = new PaintShop();
            List<String> outputs = paintShop.execute(System.in);
            outputs.forEach(System.out::println);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    List<String> execute(InputStream inputStream) throws IOException, ParseException {

        TestCase[] testCases = Parser.parse(inputStream);

        String[] output = new String[testCases.length];

        for (int i = 0; i < testCases.length; i++) {
            TestResult result = Solver.processTestCase(testCases[i]);
            output[i] = String.format("Case #%d: %s", i + 1, result.toString());
        }

        return Arrays.asList(output);
    }
}
