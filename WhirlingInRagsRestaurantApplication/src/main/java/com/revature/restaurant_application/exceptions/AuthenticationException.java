package com.revature.restaurant_application.exceptions;



    public class AuthenticationException extends RuntimeException {

        public AuthenticationException(String message) {
            super(message);
        }
    }

