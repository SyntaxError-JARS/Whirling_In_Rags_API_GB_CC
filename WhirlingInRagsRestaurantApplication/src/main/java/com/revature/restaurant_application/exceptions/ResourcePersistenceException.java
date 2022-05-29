package com.revature.restaurant_application.exceptions;

public class ResourcePersistenceException extends RuntimeException{
    public ResourcePersistenceException(String message) {
        super(message);
    }
}
