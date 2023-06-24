package com.poc.redis.application.dto;

import com.poc.redis.domain.enumeration.Gender;
import lombok.Data;

import java.io.Serializable;
import javax.validation.constraints.*;

/**
 * A DTO for the {@link com.poc.redis.domain.model.CustomerDetails} entity.
 */
@Data
@SuppressWarnings("common-java:DuplicatedBlocks")
public class CustomerDetailsDTO implements Serializable {

    private Long id;

    @NotNull
    private Gender gender;

    @NotNull
    private String phone;

    private AddressDTO address;

    private UserDTO user;

}
