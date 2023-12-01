package com.cursos.api.springsecuritycourse.dto;

import lombok.Data;

import java.io.Serializable;
@Data
public class RegisterUserDto implements Serializable {
    private Long id;
    private String username;
    private String name;
    private String role;
    private String jwt;


}
