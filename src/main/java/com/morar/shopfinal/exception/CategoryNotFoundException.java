package com.morar.shopfinal.exception;

public class CategoryNotFoundException extends Exception {
    @Override
    public String getMessage(){
        return "Category was not found";
    }
}
