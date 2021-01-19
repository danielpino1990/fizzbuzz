package com.fizzbuzz.CustomExceptions;

public class CustomException extends Exception {

    private static final long serialVersionUID = 1L;

    public CustomException(String s) {
        super(s);
    }
}