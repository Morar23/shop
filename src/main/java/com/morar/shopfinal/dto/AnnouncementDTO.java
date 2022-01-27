package com.morar.shopfinal.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AnnouncementDTO {

    private long id;

    private String name;

    private String description;

    private double price;

    private String address;

    private Date createdIn;

    private long categoryId;

    private long authorId;

    public AnnouncementDTO(long id, String name, String description, double price, String address, Date createdIn, long categoryId, long authorId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.address = address;
        this.createdIn = createdIn;
        this.categoryId = categoryId;
        this.authorId = authorId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreatedIn() {
        return createdIn;
    }

    public void setCreatedIn(String createdIn) throws ParseException {
        this.createdIn = new SimpleDateFormat("dd/MM/yyyy").parse(createdIn);
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }
}
