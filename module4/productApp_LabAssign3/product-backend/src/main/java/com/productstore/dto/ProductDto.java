package com.productstore.dto;

import org.antlr.v4.runtime.misc.NotNull;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto {

    private Long id;

    @NotBlank(message = "Product name is required")
    private String name;

    @NotNull
    @Positive
    private Double price;

    @NotNull
    @Min(0)
    private Integer quantity;

    private String category;
}
