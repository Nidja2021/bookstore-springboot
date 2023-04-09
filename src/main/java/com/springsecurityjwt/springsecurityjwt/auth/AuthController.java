package com.springsecurityjwt.springsecurityjwt.auth;

import com.springsecurityjwt.springsecurityjwt.auth.dto.LoginRequestDto;
import com.springsecurityjwt.springsecurityjwt.auth.dto.LoginResponseDto;
import com.springsecurityjwt.springsecurityjwt.auth.dto.RegisterRequestDto;
import com.springsecurityjwt.springsecurityjwt.auth.dto.RegisterResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<RegisterResponseDto> register(@RequestBody RegisterRequestDto registerRequestDto) {
        return ResponseEntity.ok(authService.register(registerRequestDto));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequestDto) {
        return ResponseEntity.ok(authService.login(loginRequestDto));
    }
}
