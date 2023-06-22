package com.poc.redis.application.mapper;

import com.poc.redis.application.dto.ProductCategoryDTO;
import com.poc.redis.domain.model.ProductCategory;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link ProductCategory} and its DTO {@link ProductCategoryDTO}.
 */
@Mapper(componentModel = "spring")
public interface ProductCategoryMapper extends EntityMapper<ProductCategoryDTO, ProductCategory> {}
