package com.kikoti.marathonbooking.exceptions;

public class MarathonNotFoundException extends RuntimeException {
    public MarathonNotFoundException(String message) {
        super(message);
    }
}
