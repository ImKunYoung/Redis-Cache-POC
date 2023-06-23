package com.poc.redis.application.mapper;

import com.poc.redis.application.dto.ProductCategoryDTO;
import com.poc.redis.application.dto.ProductDTO;
import com.poc.redis.domain.model.Product;
import com.poc.redis.domain.model.ProductCategory;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Product} and its DTO {@link ProductDTO}.
 */
@Mapper(componentModel = "spring")
public interface ProductMapper extends EntityMapper<ProductDTO, Product> {
    @Mapping(target = "productCategory", source = "productCategory", qualifiedByName = "productCategoryName")
    ProductDTO toDto(Product s);

    @Named("productCategoryName")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    ProductCategoryDTO toDtoProductCategoryName(ProductCategory productCategory);
}
