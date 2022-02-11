package com.morar.shopfinal.exception.impl;

public class UserIsAlreadyExistException extends Exception {
    @Override
    public String getMessage() {
        return "User is already exist";
    }
}
