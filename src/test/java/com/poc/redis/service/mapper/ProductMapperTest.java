package com.poc.redis.service.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import com.poc.redis.application.mapper.ProductMapper;
import org.junit.jupiter.api.BeforeEach;

class ProductMapperTest {

    private ProductMapper productMapper;

    @BeforeEach
    public void setUp() {
        productMapper = new ProductMapperImpl();
    }
}
