package com.cursos.api.springsecuritycourse.dto;

import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;
@Data
public class SaveuserDto implements Serializable {
    @Size(min = 5)
    private String name;

    @Size(min = 5)
    private String username;

    @Size(min = 8)
    private String password;

    @Size(min = 8)
    private String repeatedPassword;
}
