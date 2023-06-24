package com.poc.redis.application.dto;

import lombok.Data;

import java.io.Serializable;
import javax.validation.constraints.*;

/**
 * A DTO for the {@link com.poc.redis.domain.model.ProductCategory} entity.
 */
@Data
@SuppressWarnings("common-java:DuplicatedBlocks")
public class ProductCategoryDTO implements Serializable {

    private Long id;

    @NotNull
    private String name;

    private String description;

}
