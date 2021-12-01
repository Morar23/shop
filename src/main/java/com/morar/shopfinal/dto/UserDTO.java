package com.morar.shopfinal.dto;

import lombok.Data;
import lombok.NonNull;

@Data
public class UserDTO {
    @NonNull
    private String name;

    @NonNull
    private  String mail;

    @NonNull
    private String phone;

    @NonNull
    private String role;
}
