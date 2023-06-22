package com.poc.redis.service.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import com.poc.redis.application.mapper.ProductCategoryMapper;
import org.junit.jupiter.api.BeforeEach;

class ProductCategoryMapperTest {

    private ProductCategoryMapper productCategoryMapper;

    @BeforeEach
    public void setUp() {
        productCategoryMapper = new ProductCategoryMapperImpl();
    }
}
