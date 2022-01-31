package com.morar.shopfinal.exception.impl;

import com.morar.shopfinal.exception.EntityNotFoundException;

public class CategoryNotFoundException extends Exception implements EntityNotFoundException {
    @Override
    public String getMessage(){
        return "Category was not found";
    }
}
