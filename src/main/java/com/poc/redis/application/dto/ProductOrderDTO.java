package com.poc.redis.application.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import javax.validation.constraints.*;

@Data
/**
 * A DTO for the {@link com.poc.redis.domain.ProductOrder} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class ProductOrderDTO implements Serializable {

    private Long id;

    @NotNull
    @Min(value = 0)
    private Integer quantity;

    @NotNull
    @DecimalMin(value = "0")
    private BigDecimal totalPrice;

    private ProductDTO product;

    private ShoppingCartDTO cart;

}
