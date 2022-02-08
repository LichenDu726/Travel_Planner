package com.example.travelplannerbackend.exception;

public class PlaceNotExistException extends RuntimeException{
    public PlaceNotExistException(String message) {
        super(message);
    }
}
