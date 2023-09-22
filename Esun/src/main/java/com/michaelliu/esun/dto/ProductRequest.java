package com.michaelliu.esun.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
@Data
public class ProductRequest {

    @NotBlank
    private String productid;
    @NotBlank
    private String productname;
    @NotNull
    private BigDecimal price;
    @NotNull
    private Integer quantity;

}
