package com.popova;

import com.popova.exception.CalculatorInputException;

public class CalculatorImpl implements Calculator {
    private static final String SPLIT_REGEX = "\\s|,";

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
            try {
                int parsedNumber = Integer.parseInt(splitDigits[i]);
                if (parsedNumber > 100) {
                    continue;
                }
                convertedNumbers[i] = parsedNumber;
                if (convertedNumbers[i] < 0) {
                    throw new CalculatorInputException("Calculator doesn't accept negative numbers");
                }
            } catch (NumberFormatException e) {
                throw new NumberFormatException("Can't convert not numeric value");
            }
        }
    }
}
