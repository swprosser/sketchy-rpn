package com.example;

public interface Calculator<T extends Number> {
    T consume(String token) throws Exception;
}
