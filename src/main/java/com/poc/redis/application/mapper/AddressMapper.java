package com.poc.redis.application.mapper;

import com.poc.redis.application.dto.AddressDTO;
import com.poc.redis.domain.valueobject.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper extends EntityMapper<AddressDTO, Address> {
}
