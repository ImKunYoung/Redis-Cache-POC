package com.poc.redis.application.dto;

import com.poc.redis.domain.enumeration.Size;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.Lob;
import javax.validation.constraints.*;

@Data
/**
 * A DTO for the {@link com.poc.redis.domain.Product} entity.
 */
@Schema(description = "Product sold by the Online store")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class ProductDTO implements Serializable {

    private Long id;

    @NotNull
    private String name;

    private String description;

    @NotNull
    @DecimalMin(value = "0")
    private BigDecimal price;

    @NotNull
    private Size productSize;

    @Lob
    private byte[] image;

    private String imageContentType;
    private ProductCategoryDTO productCategory;

}
