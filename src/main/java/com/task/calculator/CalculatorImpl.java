package com.task.calculator;

import com.task.exception.CalculatorInputException;

public class CalculatorImpl implements Calculator {
    private static final String SPLIT_REGEX = "\\s|,";
    private static final int MAX_INPUT_VALUE = 100;
    private static final int MIN_INPUT_VALUE = 0;

    @Override
    public int calculate(String digits) {
        if (digits == null || digits.isEmpty()) {
            return 0;
        }

        String[] splitDigits = digits.split(SPLIT_REGEX);

        int[] convertedNumbers = new int[splitDigits.length];
        validateInput(splitDigits, convertedNumbers);

        int calculationResult = 0;
        for (int convertedNumber : convertedNumbers) {
            calculationResult += convertedNumber;
        }
        return calculationResult;
    }

    private void validateInput(String[] splitDigits, int[] convertedNumbers) {
        for (int i = 0; i < splitDigits.length; i++) {
            int parsedNumber;
            try {
                parsedNumber = Integer.parseInt(splitDigits[i]);
            } catch (NumberFormatException e) {
                throw new NumberFormatException(
                        "Calculator can't convert not numeric value: " + splitDigits[i]);
            }
            if (parsedNumber > MAX_INPUT_VALUE) {
                continue;
            }
            convertedNumbers[i] = parsedNumber;
            if (convertedNumbers[i] < MIN_INPUT_VALUE) {
                throw new CalculatorInputException(
                        "Calculator doesn't accept negative numbers: " + convertedNumbers[i]);
            }
        }
    }
}
