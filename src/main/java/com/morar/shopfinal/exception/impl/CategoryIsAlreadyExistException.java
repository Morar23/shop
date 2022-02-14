package com.morar.shopfinal.exception.impl;

import com.morar.shopfinal.exception.EntityIsAlreadyExistException;

public class CategoryIsAlreadyExistException extends Exception implements EntityIsAlreadyExistException {
    @Override
    public String getMessage() {
        return "Category is already exist";
    }
}
