package com.webstore.stant.stantbackend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AuthDto {
    private String name;
    private String email;
    private  String role;
    private String tooken;
    private String refreshTooken;
    private boolean isActive;

    public AuthDto(String name, String email, String role, String tooken, String refreshTooken, boolean isActive) {
        this.name = name;
        this.email = email;
        this.role = role;
        this.tooken = tooken;
        this.refreshTooken = refreshTooken;
        this.isActive = isActive;
    }

}
