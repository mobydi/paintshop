package com.paintshop;

import org.junit.Before;
import org.junit.Test;

import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;


public class PaintShopTest {

    private PaintShop paintShop;

    @Before
    public void before() throws Exception {
        paintShop = new PaintShop();
    }

    @Test
    public void should_pass_sample_from_requirement() throws Exception {
        List<String> outputs = paintShop.execute(new FileInputStream("src/test/resources/samples/sample_from_requirement.txt"));
        List<String> result = Arrays.asList(
                "Case #1: 1 0 0 0 0",
                "Case #2: IMPOSSIBLE");

        assertArrayEquals(outputs.toArray(), result.toArray());
    }

    @Test
    public void should_pass_sample_2() throws Exception {
        List<String> outputs = paintShop.execute(new FileInputStream("src/test/resources/samples/sample_2.txt"));
        List<String> result = Arrays.asList(
                "Case #1: 0 0 0 0 1",
                "Case #2: IMPOSSIBLE");

        assertArrayEquals(outputs.toArray(), result.toArray());
    }

    @Test
    public void should_pass_sample_3() throws Exception {
        List<String> outputs = paintShop.execute(new FileInputStream("src/test/resources/samples/sample_3.txt"));
        List<String> result = Arrays.asList(
                "Case #1: 0 1 0 1 0",
                "Case #2: 1 1");

        assertArrayEquals(outputs.toArray(), result.toArray());
    }

    @Test
    public void sample_big() throws Exception {
        List<String> outputs = paintShop.execute(new FileInputStream("src/test/resources/samples/sample_big.txt"));
        List<String> result = Files.readAllLines(Paths.get("src/test/resources/samples/sample_big_output.txt"));

        assertArrayEquals(outputs.toArray(), result.toArray());
    }
} 
