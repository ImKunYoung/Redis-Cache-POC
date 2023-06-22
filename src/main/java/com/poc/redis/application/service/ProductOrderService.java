package com.poc.redis.application.service;

import com.poc.redis.domain.model.ProductOrder;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link ProductOrder}.
 */
public interface ProductOrderService {
    /**
     * Save a productOrder.
     *
     * @param productOrder the entity to save.
     * @return the persisted entity.
     */
    ProductOrder save(ProductOrder productOrder);

    /**
     * Updates a productOrder.
     *
     * @param productOrder the entity to update.
     * @return the persisted entity.
     */
    ProductOrder update(ProductOrder productOrder);

    /**
     * Partially updates a productOrder.
     *
     * @param productOrder the entity to update partially.
     * @return the persisted entity.
     */
    Optional<ProductOrder> partialUpdate(ProductOrder productOrder);

    /**
     * Get all the productOrders.
     *
     * @return the list of entities.
     */
    List<ProductOrder> findAll();

    /**
     * Get all the productOrders with eager load of many-to-many relationships.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<ProductOrder> findAllWithEagerRelationships(Pageable pageable);

    /**
     * Get the "id" productOrder.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<ProductOrder> findOne(Long id);

    /**
     * Delete the "id" productOrder.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
