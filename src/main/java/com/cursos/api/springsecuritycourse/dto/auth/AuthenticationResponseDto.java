package com.cursos.api.springsecuritycourse.dto.auth;

import lombok.Data;

import java.io.Serializable;
@Data
public class AuthenticationResponseDto implements Serializable {
    private String jwt;
}
