package com.webstore.stant.stantbackend.service.impl;



import com.webstore.stant.stantbackend.dto.LoginRequest;
import com.webstore.stant.stantbackend.dto.LoginResponse;
import com.webstore.stant.stantbackend.dto.RefreshTokenRequest;
import com.webstore.stant.stantbackend.service.AuthService;
import com.webstore.stant.stantbackend.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtUtil jwtUtil;

    private  String myaccessToken ;
    private  String myrefreshToken;
    @Override
    public LoginResponse login(LoginRequest loginRequest, boolean isActive) {
        String email  = loginRequest.getEmail();
        if(!isActive){
            email += "`12!";
        }
        try {
            var result = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(email,
                            loginRequest.getPassword())

            );
        } catch (BadCredentialsException e) {
            log.info("Bad Credentials");
        }

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(loginRequest.getEmail());

        final String accessToken = jwtUtil.generateToken(userDetails);
        final String refreshToken = jwtUtil.generateRefreshToken(loginRequest.getEmail());
        var loginResponse = new LoginResponse(accessToken, refreshToken);

        this.myaccessToken = accessToken;
        this.myrefreshToken = refreshToken;
        return loginResponse;
    }

    public String getMyaccessToken() {
        return myaccessToken;
    }

    public String getMyrefreshToken() {
        return myrefreshToken;
    }

    @Override
    public LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest) {
        boolean isRefreshTokenValid = jwtUtil.validateToken(refreshTokenRequest.getRefreshToken());
        if (isRefreshTokenValid) {
            final String accessToken = jwtUtil.doGenerateToken( jwtUtil.getSubject(refreshTokenRequest.getRefreshToken()));
            var loginResponse = new LoginResponse(accessToken, refreshTokenRequest.getRefreshToken());
            return loginResponse;
        }
        return new LoginResponse();
    }
}
