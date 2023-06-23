package com.poc.redis.application.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Objects;
import javax.validation.constraints.*;

@Data
/**
 * A DTO for the {@link com.poc.redis.domain.ProductCategory} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class ProductCategoryDTO implements Serializable {

    private Long id;

    @NotNull
    private String name;

    private String description;

}
