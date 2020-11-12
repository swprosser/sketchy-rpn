package com.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DoubleCalculatorTest {

    @Test
    void testConsume() throws Exception {
        DoubleCalculator calc = new DoubleCalculator();

        calc.consume("5");
        calc.consume("8");
        assertEquals(13.0, calc.consume("+"));

        calc.consume("-3");
        calc.consume("-2");
        calc.consume("*");
        calc.consume("5");
        assertEquals(11.0, calc.consume("+"));

        calc.consume("5");
        calc.consume("9");
        calc.consume("1");
        calc.consume("-");
        assertEquals(0.625, calc.consume("/"));
    }

}
