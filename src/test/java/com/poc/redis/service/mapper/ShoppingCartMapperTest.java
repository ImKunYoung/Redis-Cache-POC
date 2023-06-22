package com.poc.redis.service.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import com.poc.redis.application.mapper.ShoppingCartMapper;
import org.junit.jupiter.api.BeforeEach;

class ShoppingCartMapperTest {

    private ShoppingCartMapper shoppingCartMapper;

    @BeforeEach
    public void setUp() {
        shoppingCartMapper = new ShoppingCartMapperImpl();
    }
}
