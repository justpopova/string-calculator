package com.task;

import com.task.calculator.Calculator;
import com.task.calculator.CalculatorImpl;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new CalculatorImpl();
        //Sample output
        System.out.println(calculator.calculate("1,2,3 4 5"));
       // System.out.println(calculator.calculate("1,2,3 %4 5,6")); //throws exception
        System.out.println(calculator.calculate(""));
        System.out.println(calculator.calculate(null));
       // System.out.println(calculator.calculate("1,-2,3,4")); //throws exception
        System.out.println(calculator.calculate("1,3,5,101,103,2"));
    }
}
