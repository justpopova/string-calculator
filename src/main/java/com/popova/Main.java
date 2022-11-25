package com.popova;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new CalculatorImpl();
        //Sample output
        System.out.println(calculator.calculate("1,2,3 4 5,6"));
//        System.out.println(calculator.calculate(""));
        System.out.println(calculator.calculate(null));
        System.out.println(calculator.calculate("1,-2,3,4"));
        System.out.println(calculator.calculate("1,3,5,101,103,2"));
    }
}
