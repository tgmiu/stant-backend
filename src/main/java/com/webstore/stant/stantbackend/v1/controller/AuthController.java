package com.webstore.stant.stantbackend.v1.controller;

import com.webstore.stant.stantbackend.dto.AuthDto;
import com.webstore.stant.stantbackend.dto.LoginRequest;
import com.webstore.stant.stantbackend.dto.LoginResponse;
import com.webstore.stant.stantbackend.dto.RefreshTokenRequest;
import com.webstore.stant.stantbackend.entity.User;
import com.webstore.stant.stantbackend.service.AuthService;
import com.webstore.stant.stantbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(AuthController.BASE_URL)
@CrossOrigin
public class AuthController {

final static String BASE_URL="/api/v1/users";
    private final AuthService authService;

    @Autowired
    UserService userService;
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthDto> login(@RequestBody LoginRequest loginRequest) {
        User user  = userService.findByEmailAddress(loginRequest.getEmail());

        var loginResponse = authService.login(loginRequest, user.isActive());
         String accessToken = loginResponse.getAccessToken();
         String refreshtoe = loginResponse.getRefreshToken();
        AuthDto userRegisterDto = new AuthDto(user.getName(), user.getEmail(),  user.getRoles().get(0).getRole(),  accessToken, refreshtoe, user.isActive());
        System.out.println("*****************DATA IS ****** " + userRegisterDto);
        return ResponseEntity.ok().body(userRegisterDto);
    }

    @PostMapping("/refreshToken")
    public LoginResponse refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest){
        return authService.refreshToken(refreshTokenRequest);
    }

}
