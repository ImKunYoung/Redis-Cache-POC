package com.poc.redis.application.service;

import com.poc.redis.domain.model.ShoppingCart;
import com.poc.redis.infrastructure.repository.ShoppingCartRepository;
import com.poc.redis.application.dto.ShoppingCartDTO;
import com.poc.redis.application.mapper.ShoppingCartMapper;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link ShoppingCart}.
 */
@Service
@Transactional
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private final Logger log = LoggerFactory.getLogger(ShoppingCartServiceImpl.class);

    private final ShoppingCartRepository shoppingCartRepository;

    private final ShoppingCartMapper shoppingCartMapper;

    public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository, ShoppingCartMapper shoppingCartMapper) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.shoppingCartMapper = shoppingCartMapper;
    }

    @Override
    public ShoppingCartDTO save(ShoppingCartDTO shoppingCartDTO) {
        log.debug("Request to save ShoppingCart : {}", shoppingCartDTO);
        ShoppingCart shoppingCart = shoppingCartMapper.toEntity(shoppingCartDTO);
        shoppingCart = shoppingCartRepository.save(shoppingCart);
        return shoppingCartMapper.toDto(shoppingCart);
    }

    @Override
    public ShoppingCartDTO update(ShoppingCartDTO shoppingCartDTO) {
        log.debug("Request to update ShoppingCart : {}", shoppingCartDTO);
        ShoppingCart shoppingCart = shoppingCartMapper.toEntity(shoppingCartDTO);
        shoppingCart = shoppingCartRepository.save(shoppingCart);
        return shoppingCartMapper.toDto(shoppingCart);
    }

    @Override
    public Optional<ShoppingCartDTO> partialUpdate(ShoppingCartDTO shoppingCartDTO) {
        log.debug("Request to partially update ShoppingCart : {}", shoppingCartDTO);

        return shoppingCartRepository
            .findById(shoppingCartDTO.getId())
            .map(existingShoppingCart -> {
                shoppingCartMapper.partialUpdate(existingShoppingCart, shoppingCartDTO);

                return existingShoppingCart;
            })
            .map(shoppingCartRepository::save)
            .map(shoppingCartMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ShoppingCartDTO> findAll() {
        log.debug("Request to get all ShoppingCarts");
        return shoppingCartRepository.findAll().stream().map(shoppingCartMapper::toDto).collect(Collectors.toCollection(LinkedList::new));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ShoppingCartDTO> findOne(Long id) {
        log.debug("Request to get ShoppingCart : {}", id);
        return shoppingCartRepository.findById(id).map(shoppingCartMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete ShoppingCart : {}", id);
        shoppingCartRepository.deleteById(id);
    }
}
