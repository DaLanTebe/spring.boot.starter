package com.example.springbootstarter.exception;

public class ConcurrencyStartupException extends RuntimeException {

    public ConcurrencyStartupException() {}

    public ConcurrencyStartupException(String message) {
        super(message);
    }
}
