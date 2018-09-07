package com.paintshop;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.FileInputStream;
import java.text.ParseException;


public class ParserTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test()
    public void should_not_parse_empty_file() throws Exception {
        thrown.expect(ParseException.class);
        thrown.expectMessage("The number of test cases is not defined");

        Parser.parse(new FileInputStream("src/test/resources/parser/parser_empty_file.txt"));
    }

    @Test()
    public void should_not_parse_with_letter_in_test_cases() throws Exception {
        thrown.expect(ParseException.class);
        thrown.expectMessage("The number of test cases is not defined");

        Parser.parse(new FileInputStream("src/test/resources/parser/parser_letter_in_test_case.txt"));
    }

    @Test()
    public void should_not_parse_with_letter_in_color() throws Exception {
        thrown.expect(ParseException.class);
        thrown.expectMessage("The number of colors is not defined");

        Parser.parse(new FileInputStream("src/test/resources/parser/parser_letter_in_color.txt"));
    }

    @Test()
    public void should_not_parse_with_letter_in_customer() throws Exception {
        thrown.expect(ParseException.class);
        thrown.expectMessage("The number of customers is not defined");

        Parser.parse(new FileInputStream("src/test/resources/parser/parser_letter_in_customer.txt"));
    }

    @Test()
    public void should_not_parse_with_max_paint() throws Exception {
        thrown.expect(ParseException.class);
        thrown.expectMessage("The paint is max that defined");

        Parser.parse(new FileInputStream("src/test/resources/parser/parser_max_paint.txt"));
    }

    @Test()
    public void should_not_parse_with_max_color() throws Exception {
        thrown.expect(ParseException.class);
        thrown.expectMessage("The color is not that 0 or 1");

        Parser.parse(new FileInputStream("src/test/resources/parser/parser_max_color.txt"));
    }

    @Test()
    public void should_not_parse_number_of_pairs() throws Exception {
        thrown.expect(ParseException.class);
        thrown.expectMessage("The number of paint is not defined");

        Parser.parse(new FileInputStream("src/test/resources/parser/parser_number_of_pairs.txt"));
    }
}
