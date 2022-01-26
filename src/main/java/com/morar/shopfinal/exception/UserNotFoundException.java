package com.morar.shopfinal.exception;

public class UserNotFoundException extends Exception {
    @Override
    public String getMessage() {
        return "User was not found";
    }
}
