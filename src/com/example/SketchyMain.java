package com.example;

import java.util.Scanner;

public class SketchyMain {

    public static void main(String[] args) {
        Calculator<Double> calculator = new DoubleCalculator();
        try (Scanner scanner = new Scanner(System.in)) {
            while (scanner.hasNext()) {
                String token = scanner.next();
                if (token == "q") {
                    break;
                }
                Double result = calculator.consume(token);
                System.out.println(result);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
