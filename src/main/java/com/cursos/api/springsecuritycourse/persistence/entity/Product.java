package com.cursos.api.springsecuritycourse.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private BigDecimal price;
    //anotacion para guardar el string y no el valor ordinal(0,1,...)
    @Enumerated(EnumType.STRING)
    private ProductStatus status;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    public static enum ProductStatus{
        ENABLED, DISABLED
    }


}
