package com.poc.redis.application.mapper;

import com.poc.redis.application.dto.CustomerDetailsDTO;
import com.poc.redis.application.dto.ShoppingCartDTO;
import com.poc.redis.domain.model.CustomerDetails;
import com.poc.redis.domain.model.ShoppingCart;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link ShoppingCart} and its DTO {@link ShoppingCartDTO}.
 */
@Mapper(componentModel = "spring")
public interface ShoppingCartMapper extends EntityMapper<ShoppingCartDTO, ShoppingCart> {
    @Mapping(target = "customerDetails", source = "customerDetails", qualifiedByName = "customerDetailsId")
    ShoppingCartDTO toDto(ShoppingCart s);

    @Named("customerDetailsId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    CustomerDetailsDTO toDtoCustomerDetailsId(CustomerDetails customerDetails);
}
