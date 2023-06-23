package com.poc.redis.application.dto;

import com.poc.redis.domain.enumeration.OrderStatus;
import com.poc.redis.domain.enumeration.PaymentMethod;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;
import javax.validation.constraints.*;

@Data
/**
 * A DTO for the {@link com.poc.redis.domain.ShoppingCart} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class ShoppingCartDTO implements Serializable {

    private Long id;

    @NotNull
    private Instant placedDate;

    @NotNull
    private OrderStatus status;

    @NotNull
    @DecimalMin(value = "0")
    private BigDecimal totalPrice;

    @NotNull
    private PaymentMethod paymentMethod;

    private String paymentReference;

    private CustomerDetailsDTO customerDetails;

}
