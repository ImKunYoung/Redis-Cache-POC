package com.poc.redis.application.mapper;

import com.poc.redis.application.dto.CustomerDetailsDTO;
import com.poc.redis.application.dto.UserDTO;
import com.poc.redis.domain.model.CustomerDetails;
import com.poc.redis.domain.model.User;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link CustomerDetails} and its DTO {@link CustomerDetailsDTO}.
 */
@Mapper(componentModel = "spring")
public interface CustomerDetailsMapper extends EntityMapper<CustomerDetailsDTO, CustomerDetails> {
    @Mapping(target = "user", source = "user", qualifiedByName = "userLogin")
    CustomerDetailsDTO toDto(CustomerDetails s);

    @Named("userLogin")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "login", source = "login")
    UserDTO toDtoUserLogin(User user);
}
