package com.morar.shopfinal.dto;

import lombok.Data;
import lombok.NonNull;

import java.util.Date;

@Data
public class AnnouncementDTO {
    private long id;

    @NonNull
    private  String name;

    @NonNull
    private String description;

    private double price;

    @NonNull
    private String address;

    @NonNull
    private Date created_in;

    private long categoryId;
}
