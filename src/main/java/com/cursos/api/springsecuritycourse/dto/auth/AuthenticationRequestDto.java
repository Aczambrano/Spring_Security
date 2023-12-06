package com.cursos.api.springsecuritycourse.dto.auth;

import lombok.Data;

import java.io.Serializable;

@Data
public class AuthenticationRequestDto implements Serializable {
    private String username;
    private String password;
}
