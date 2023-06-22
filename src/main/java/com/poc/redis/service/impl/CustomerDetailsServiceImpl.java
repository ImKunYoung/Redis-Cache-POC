package com.poc.redis.service.impl;

import com.poc.redis.domain.CustomerDetails;
import com.poc.redis.repository.CustomerDetailsRepository;
import com.poc.redis.service.CustomerDetailsService;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link CustomerDetails}.
 */
@Service
@Transactional
public class CustomerDetailsServiceImpl implements CustomerDetailsService {

    private final Logger log = LoggerFactory.getLogger(CustomerDetailsServiceImpl.class);

    private final CustomerDetailsRepository customerDetailsRepository;

    public CustomerDetailsServiceImpl(CustomerDetailsRepository customerDetailsRepository) {
        this.customerDetailsRepository = customerDetailsRepository;
    }

    @Override
    public CustomerDetails save(CustomerDetails customerDetails) {
        log.debug("Request to save CustomerDetails : {}", customerDetails);
        return customerDetailsRepository.save(customerDetails);
    }

    @Override
    public CustomerDetails update(CustomerDetails customerDetails) {
        log.debug("Request to update CustomerDetails : {}", customerDetails);
        return customerDetailsRepository.save(customerDetails);
    }

    @Override
    public Optional<CustomerDetails> partialUpdate(CustomerDetails customerDetails) {
        log.debug("Request to partially update CustomerDetails : {}", customerDetails);

        return customerDetailsRepository
            .findById(customerDetails.getId())
            .map(existingCustomerDetails -> {
                if (customerDetails.getGender() != null) {
                    existingCustomerDetails.setGender(customerDetails.getGender());
                }
                if (customerDetails.getPhone() != null) {
                    existingCustomerDetails.setPhone(customerDetails.getPhone());
                }
                if (customerDetails.getAddressLine1() != null) {
                    existingCustomerDetails.setAddressLine1(customerDetails.getAddressLine1());
                }
                if (customerDetails.getAddressLine2() != null) {
                    existingCustomerDetails.setAddressLine2(customerDetails.getAddressLine2());
                }
                if (customerDetails.getCity() != null) {
                    existingCustomerDetails.setCity(customerDetails.getCity());
                }
                if (customerDetails.getCountry() != null) {
                    existingCustomerDetails.setCountry(customerDetails.getCountry());
                }

                return existingCustomerDetails;
            })
            .map(customerDetailsRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<CustomerDetails> findAll(Pageable pageable) {
        log.debug("Request to get all CustomerDetails");
        return customerDetailsRepository.findAll(pageable);
    }

    public Page<CustomerDetails> findAllWithEagerRelationships(Pageable pageable) {
        return customerDetailsRepository.findAllWithEagerRelationships(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<CustomerDetails> findOne(Long id) {
        log.debug("Request to get CustomerDetails : {}", id);
        return customerDetailsRepository.findOneWithEagerRelationships(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete CustomerDetails : {}", id);
        customerDetailsRepository.deleteById(id);
    }
}
