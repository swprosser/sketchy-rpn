package com.example;

import java.util.ArrayDeque;
import java.util.Deque;

public class DoubleCalculator implements Calculator<Double> {
    Deque<Double> stack = new ArrayDeque<>();

    @Override
    public Double consume(String token) throws Exception {
        Double number = parseDouble(token);
        if (number == null) {
            if (token.equals("+")) {
                number = plus();
            } else if (token.equals("*")) {
                number = multiply();
            } else if (token.equals("/")) {
                number = divide();
            } else if (token.equals("-")) {
                number = minus();
            } else {
                throw new Exception("Unexpected input: '" + token + "'");
            }
        }
        stack.push(number);
        return number;
    }

    Double plus() {
        return stack.pop() + stack.pop();
    }

    Double multiply() {
        return stack.pop() * stack.pop();
    }

    Double divide() {
        Double n = stack.pop();
        return stack.pop() / n;
    }

    Double minus() {
        Double n = stack.pop();
        return stack.pop() - n;
    }

    Double parseDouble(String token) {
        try {
            return Double.valueOf(token);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    @Override
    public String toString() {
        return stack.toString();
    }
}
