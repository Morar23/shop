package com.morar.shopfinal.exception.impl;

import com.morar.shopfinal.exception.EntityIsAlreadyExistException;

public class UserIsAlreadyExistException extends Exception implements EntityIsAlreadyExistException {
    @Override
    public String getMessage() {
        return "User is already exist";
    }
}
