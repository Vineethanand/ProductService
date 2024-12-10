package com.product.productservice.testdemo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class CalculatorTest {

    @Test
    void whenAddTwoIntegersThenRightResultExpected()
    {
        int a=10;
        int b=20;
        Calculator calc = new Calculator();
        int result = calc.add(a,b);
        Assertions.assertEquals(30,result);
    }

    @Test
    void  whenDivideByZeroThrowsException()
    {
        Calculator calc = new Calculator();
        int a= 10;
        int b=0;

        Assertions.assertThrows(ArithmeticException.class, () -> {calc.divide(a,b);});
    }
}