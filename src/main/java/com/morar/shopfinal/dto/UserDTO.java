package com.morar.shopfinal.dto;

import lombok.Data;
import lombok.NonNull;

@Data
public class UserDTO {
    Long id;

    @NonNull
    private String name;

    @NonNull
    private  String mail;

    @NonNull
    private String phone;

    @NonNull
    private String password;

    @NonNull
    private String role;

    public UserDTO(Long id, @NonNull String name, @NonNull String mail, @NonNull String phone, @NonNull String password, @NonNull String role) {
        this.id = id;
        this.name = name;
        this.mail = mail;
        this.phone = phone;
        this.password = password;
        this.role = role;
    }
}
