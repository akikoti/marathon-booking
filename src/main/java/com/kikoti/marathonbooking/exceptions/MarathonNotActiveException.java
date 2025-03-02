package com.kikoti.marathonbooking.exceptions;

public class MarathonNotActiveException extends RuntimeException {
    public MarathonNotActiveException(String message) {
        super(message);
    }
}