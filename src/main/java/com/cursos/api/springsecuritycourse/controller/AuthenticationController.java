package com.cursos.api.springsecuritycourse.controller;

import com.cursos.api.springsecuritycourse.dto.auth.AuthenticationRequestDto;
import com.cursos.api.springsecuritycourse.dto.auth.AuthenticationResponseDto;
import com.cursos.api.springsecuritycourse.service.authentication.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationService authenticationService;


    @GetMapping("/validate")
    public ResponseEntity<Boolean> validate(@RequestParam String jwt){
        boolean isTokenValid = authenticationService.validateToken(jwt);

        return ResponseEntity.ok(isTokenValid);

    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponseDto> login(
            @RequestBody @Valid AuthenticationRequestDto authenticationRequestDto){
        AuthenticationResponseDto resp = authenticationService.login(authenticationRequestDto);
        return  ResponseEntity.ok(resp);
    }
}
