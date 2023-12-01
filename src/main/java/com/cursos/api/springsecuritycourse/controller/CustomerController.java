package com.cursos.api.springsecuritycourse.controller;

import com.cursos.api.springsecuritycourse.dto.RegisterUserDto;
import com.cursos.api.springsecuritycourse.dto.SaveuserDto;
import com.cursos.api.springsecuritycourse.service.authentication.AuthenticateService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private AuthenticateService authenticateService;
    @PostMapping()
    public ResponseEntity<RegisterUserDto> registerUser(@RequestBody @Valid SaveuserDto newUser){
        RegisterUserDto redisterUserDto = authenticateService.registerCustomer(newUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(redisterUserDto);
    }
}
