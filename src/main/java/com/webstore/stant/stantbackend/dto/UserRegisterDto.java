package com.webstore.stant.stantbackend.dto;

import lombok.Data;

@Data
public class UserRegisterDto {
    private String name;
    private String email;
    private  String role;
    private String password;
    private boolean isActive;

    public UserRegisterDto(String name, String email, String role, String password, boolean isActive) {
        this.name = name;
        this.email = email;
        this.role = role;
        this.password = password;
        this.isActive = isActive;
    }
}
