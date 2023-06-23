package com.poc.redis.application.service;

import com.poc.redis.application.dto.ShoppingCartDTO;
import com.poc.redis.domain.model.ShoppingCart;
import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link ShoppingCart}.
 */
public interface ShoppingCartService {
    /**
     * Save a shoppingCart.
     *
     * @param shoppingCartDTO the entity to save.
     * @return the persisted entity.
     */
    ShoppingCartDTO save(ShoppingCartDTO shoppingCartDTO);

    /**
     * Updates a shoppingCart.
     *
     * @param shoppingCartDTO the entity to update.
     * @return the persisted entity.
     */
    ShoppingCartDTO update(ShoppingCartDTO shoppingCartDTO);

    /**
     * Partially updates a shoppingCart.
     *
     * @param shoppingCartDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<ShoppingCartDTO> partialUpdate(ShoppingCartDTO shoppingCartDTO);

    /**
     * Get all the shoppingCarts.
     *
     * @return the list of entities.
     */
    List<ShoppingCartDTO> findAll();

    /**
     * Get the "id" shoppingCart.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<ShoppingCartDTO> findOne(Long id);

    /**
     * Delete the "id" shoppingCart.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
