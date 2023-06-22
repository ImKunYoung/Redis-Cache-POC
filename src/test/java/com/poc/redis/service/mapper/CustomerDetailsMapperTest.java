package com.poc.redis.service.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import com.poc.redis.application.mapper.CustomerDetailsMapper;
import org.junit.jupiter.api.BeforeEach;

class CustomerDetailsMapperTest {

    private CustomerDetailsMapper customerDetailsMapper;

    @BeforeEach
    public void setUp() {
        customerDetailsMapper = new CustomerDetailsMapperImpl();
    }
}
