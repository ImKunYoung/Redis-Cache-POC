package com.poc.redis.application.service;

import com.poc.redis.domain.model.CustomerDetails;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link CustomerDetails}.
 */
public interface CustomerDetailsService {
    /**
     * Save a customerDetails.
     *
     * @param customerDetails the entity to save.
     * @return the persisted entity.
     */
    CustomerDetails save(CustomerDetails customerDetails);

    /**
     * Updates a customerDetails.
     *
     * @param customerDetails the entity to update.
     * @return the persisted entity.
     */
    CustomerDetails update(CustomerDetails customerDetails);

    /**
     * Partially updates a customerDetails.
     *
     * @param customerDetails the entity to update partially.
     * @return the persisted entity.
     */
    Optional<CustomerDetails> partialUpdate(CustomerDetails customerDetails);

    /**
     * Get all the customerDetails.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<CustomerDetails> findAll(Pageable pageable);

    /**
     * Get all the customerDetails with eager load of many-to-many relationships.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<CustomerDetails> findAllWithEagerRelationships(Pageable pageable);

    /**
     * Get the "id" customerDetails.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<CustomerDetails> findOne(Long id);

    /**
     * Delete the "id" customerDetails.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
