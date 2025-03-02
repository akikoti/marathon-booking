package com.kikoti.marathonbooking.exceptions;

public class MarathonFullException extends RuntimeException {
    public MarathonFullException(String message) {
        super(message);
    }
}