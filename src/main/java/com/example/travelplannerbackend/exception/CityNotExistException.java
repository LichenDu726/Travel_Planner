package com.example.travelplannerbackend.exception;

public class CityNotExistException extends RuntimeException{
    public CityNotExistException(String message) {
        super(message);
    }
}
