package com.webstore.stant.stantbackend.service;


import com.webstore.stant.stantbackend.dto.LoginRequest;
import com.webstore.stant.stantbackend.dto.LoginResponse;
import com.webstore.stant.stantbackend.dto.RefreshTokenRequest;

public interface AuthService {
    LoginResponse login(LoginRequest loginRequest, boolean isActive);
    LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
