package com.poc.redis.application.service;

import com.poc.redis.application.dto.CustomerDetailsDTO;
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
     * @param customerDetailsDTO the entity to save.
     * @return the persisted entity.
     */
    CustomerDetailsDTO save(CustomerDetailsDTO customerDetailsDTO);

    /**
     * Updates a customerDetails.
     *
     * @param customerDetailsDTO the entity to update.
     * @return the persisted entity.
     */
    CustomerDetailsDTO update(CustomerDetailsDTO customerDetailsDTO);

    /**
     * Partially updates a customerDetails.
     *
     * @param customerDetailsDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<CustomerDetailsDTO> partialUpdate(CustomerDetailsDTO customerDetailsDTO);

    /**
     * Get all the customerDetails.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<CustomerDetailsDTO> findAll(Pageable pageable);

    /**
     * Get all the customerDetails with eager load of many-to-many relationships.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<CustomerDetailsDTO> findAllWithEagerRelationships(Pageable pageable);

    /**
     * Get the "id" customerDetails.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<CustomerDetailsDTO> findOne(Long id);

    /**
     * Delete the "id" customerDetails.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
