package com.example.travelplannerbackend.exception;

public class PlanNotFoundException extends RuntimeException{
    public PlanNotFoundException(String message) {
        super(message);
    }
}