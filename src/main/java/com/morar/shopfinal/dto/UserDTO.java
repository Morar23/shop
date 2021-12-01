package com.morar.shopfinal.dto;

import lombok.Data;

@Data
public class UserDTO {
    private Long id;

    private String name;

    private  String mail;

    private String phone;

    private String role;
}
