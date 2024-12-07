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
}