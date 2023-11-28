package com.cursos.api.springsecuritycourse.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApiError implements Serializable {
    private String backendMessage;
    private String message;
    private String url;
    private String method;
    private LocalDateTime timestamp;
}
