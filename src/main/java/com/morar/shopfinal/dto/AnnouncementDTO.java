package com.morar.shopfinal.dto;

import org.springframework.lang.NonNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AnnouncementDTO {

    private Long id;

    private String name;

    private String description;

    private Double price;

    private String address;

    private Date createdIn;

    private Long categoryId;

    private Long authorId;

    public AnnouncementDTO(Long id, String name, String description, Double price, String address, Date createdIn, Long categoryId, Long authorId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.address = address;
        this.createdIn = createdIn;
        this.categoryId = categoryId;
        this.authorId = authorId;
    }

    @NonNull
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NonNull
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @NonNull
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @NonNull
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @NonNull
    public Date getCreatedIn() {
        return createdIn;
    }

    public void setCreatedIn(String createdIn) throws ParseException {
        this.createdIn = new SimpleDateFormat("dd/MM/yyyy").parse(createdIn);
    }

    @NonNull
    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    @NonNull
    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }
}
