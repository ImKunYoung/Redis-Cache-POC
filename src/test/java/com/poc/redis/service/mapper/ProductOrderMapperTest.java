package com.poc.redis.service.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import com.poc.redis.application.mapper.ProductOrderMapper;
import org.junit.jupiter.api.BeforeEach;

class ProductOrderMapperTest {

    private ProductOrderMapper productOrderMapper;

    @BeforeEach
    public void setUp() {
        productOrderMapper = new ProductOrderMapperImpl();
    }
}
