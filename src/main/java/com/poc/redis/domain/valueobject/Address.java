package com.poc.redis.domain.valueobject;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Embeddable
public class Address implements Serializable {

    @NotNull
    @Column(name = "address_line_1", nullable = false)
    private String addressLine1;

    @Column(name = "address_line_2")
    private String addressLine2;

    @NotNull
    @Column(name = "city", nullable = false)
    private String city;

    @NotNull
    @Column(name = "country", nullable = false)
    private String country;

}
