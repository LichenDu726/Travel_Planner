package com.example.travelplannerbackend.exception;

public class SchedulerNotFoundException extends RuntimeException{
    public SchedulerNotFoundException(String message) {
        super(message);
    }
}