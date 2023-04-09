package com.bookstore.auth;

import com.bookstore.auth.dto.LoginRequestDto;
import com.bookstore.auth.dto.LoginResponseDto;
import com.bookstore.auth.dto.RegisterRequestDto;
import com.bookstore.auth.dto.RegisterResponseDto;
import com.bookstore.config.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserReposity userReposity;
    private final JwtUtils jwtUtils;
    private final PasswordEncoder passwordEncoder;

    public RegisterResponseDto register(RegisterRequestDto registerRequestDto) {
        var user = User.builder()
                .username(registerRequestDto.getUsername())
                .email(registerRequestDto.getEmail())
                .password(passwordEncoder.encode(registerRequestDto.getPassword()))
                .role(Role.USER)
                .build();

        userReposity.save(user);

        return RegisterResponseDto.builder()
                .email(registerRequestDto.getEmail())
                .build();
    }

    public LoginResponseDto login(LoginRequestDto loginRequestDto) {
        User user = userReposity.findUserByEmail(loginRequestDto.getEmail()).get();
        var accessToken = jwtUtils.generateToken(user);
        return LoginResponseDto.builder()
                .accessToken(accessToken)
                .build();
    }
}
