package com.morar.shopfinal.exception.impl;

import com.morar.shopfinal.exception.EntityNotFoundException;

public class AnnouncementNotFoundException extends Exception implements EntityNotFoundException {
    @Override
    public String getMessage(){
        return "Announcement was not found";
    }
}
