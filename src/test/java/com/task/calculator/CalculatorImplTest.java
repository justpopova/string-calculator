package com.task.calculator;

import com.task.exception.CalculatorInputException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorImplTest {
    private Calculator calculator;

    @BeforeEach
    public void init() {
        this.calculator = new CalculatorImpl();
    }

    @Test
    public void calculate_string_space_separator() {
        String actual = "1 2";
        int expected = 3;
        Assertions.assertEquals(expected, calculator.calculate(actual));
    }

    @Test
    public void calculate_string_comma_separator() {
        String actual = "1,2";
        int expected = 3;
        Assertions.assertEquals(expected, calculator.calculate(actual));
    }

    @Test
    public void calculate_string_multiple_separators() {
        String actual = "1,2 3";
        int expected = 6;
        Assertions.assertEquals(expected, calculator.calculate(actual));
    }

    @Test
    public void calculate_string_multiple_repeated_separators() {
        String actual = "1, 2";
        Assertions.assertThrows(RuntimeException.class, () -> calculator.calculate(actual),
                "Input can't have multiple separators: " + actual);
    }

    @Test
    public void calculate_string_not_supported_splitters() {
        String actual = "1 2 %3; 4";
        Assertions.assertThrows(RuntimeException.class, () -> calculator.calculate(actual),
                "Calculator supports just space and comma as separators. Your input: " + actual);
    }

    @Test()
    public void calculate_negativeNumbers_notValid() {
        String actual = "1,3,-6";
        Assertions.assertThrows(CalculatorInputException.class, () -> calculator.calculate(actual),
                "Calculator doesn't accept negative numbers: " + actual);
    }

    @Test
    public void calculate_null_must_return_0() {
        String actual = null;
        int expected = 0;
        Assertions.assertEquals(expected, calculator.calculate(actual),
                "If input parameter is null, must return 0." + actual);
    }

    @Test()
    public void calculate_emptyString_must_return_0() {
        String actual = "";
        int expected = 0;
        Assertions.assertEquals(expected, calculator.calculate(actual),
                "If string is empty, must return 0(zero).");
    }

    @Test
    public void calculate_numbers_over_100_ignored() {
        String actual = "1,2 3,5,101";
        int expected = 11;
        Assertions.assertEquals(expected, calculator.calculate(actual),
                "Numbers over 100 must be ignored." + actual);
    }
}