package com.morar.shopfinal.exception;

public class AnnouncementNotFoundException extends Exception{

    @Override
    public String getMessage(){
        return "Announcement was not found";
    }
}
