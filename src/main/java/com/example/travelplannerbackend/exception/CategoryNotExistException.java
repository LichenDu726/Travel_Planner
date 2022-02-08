package com.example.travelplannerbackend.exception;

public class CategoryNotExistException extends RuntimeException{
    public CategoryNotExistException(String message) {
        super(message);
    }
}
