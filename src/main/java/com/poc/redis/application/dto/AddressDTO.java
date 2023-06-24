package com.poc.redis.application.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class AddressDTO {

    @NotNull
    private String addressLine1;

    private String addressLine2;

    @NotNull
    private String city;

    @NotNull
    private String country;
}
