package com.example.helloworld.exception;

public class ProductNotFoundException extends Exception{
    public ProductNotFoundException(String message) {
        super(message);
    }
}
