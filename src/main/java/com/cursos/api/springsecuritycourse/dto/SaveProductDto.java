package com.cursos.api.springsecuritycourse.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SaveProductDto implements Serializable {
    @NotBlank(message = "el nombre no debe de ser vacío")
    private String name;

    @DecimalMin(value = "0.01", message = "el precio debe de ser mayor a cero")
    private BigDecimal price;

    @Min(value = 1)
    private Long categoryId;
}
