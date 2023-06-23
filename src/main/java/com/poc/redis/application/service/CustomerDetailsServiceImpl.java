package com.poc.redis.application.service;

import com.poc.redis.domain.model.CustomerDetails;
import com.poc.redis.infrastructure.repository.CustomerDetailsRepository;
import com.poc.redis.application.dto.CustomerDetailsDTO;
import com.poc.redis.application.mapper.CustomerDetailsMapper;
import java.util.Optional;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link CustomerDetails}.
 */
@Slf4j
@Service
@Transactional
public class CustomerDetailsServiceImpl implements CustomerDetailsService {

    private final CustomerDetailsRepository customerDetailsRepository;

    private final CustomerDetailsMapper customerDetailsMapper;

    public CustomerDetailsServiceImpl(CustomerDetailsRepository customerDetailsRepository, CustomerDetailsMapper customerDetailsMapper) {
        this.customerDetailsRepository = customerDetailsRepository;
        this.customerDetailsMapper = customerDetailsMapper;
    }

    @Override
    public CustomerDetailsDTO save(CustomerDetailsDTO customerDetailsDTO) {
        log.debug("Request to save CustomerDetails : {}", customerDetailsDTO);
        CustomerDetails customerDetails = customerDetailsMapper.toEntity(customerDetailsDTO);
        customerDetails = customerDetailsRepository.save(customerDetails);
        return customerDetailsMapper.toDto(customerDetails);
    }

    @Override
    public CustomerDetailsDTO update(CustomerDetailsDTO customerDetailsDTO) {
        log.debug("Request to update CustomerDetails : {}", customerDetailsDTO);
        CustomerDetails customerDetails = customerDetailsMapper.toEntity(customerDetailsDTO);
        customerDetails = customerDetailsRepository.save(customerDetails);
        return customerDetailsMapper.toDto(customerDetails);
    }

    @Override
    public Optional<CustomerDetailsDTO> partialUpdate(CustomerDetailsDTO customerDetailsDTO) {
        log.debug("Request to partially update CustomerDetails : {}", customerDetailsDTO);

        return customerDetailsRepository
            .findById(customerDetailsDTO.getId())
            .map(existingCustomerDetails -> {
                customerDetailsMapper.partialUpdate(existingCustomerDetails, customerDetailsDTO);

                return existingCustomerDetails;
            })
            .map(customerDetailsRepository::save)
            .map(customerDetailsMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<CustomerDetailsDTO> findAll(Pageable pageable) {
        log.debug("Request to get all CustomerDetails");
        return customerDetailsRepository.findAll(pageable).map(customerDetailsMapper::toDto);
    }

    public Page<CustomerDetailsDTO> findAllWithEagerRelationships(Pageable pageable) {
        return customerDetailsRepository.findAllWithEagerRelationships(pageable).map(customerDetailsMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<CustomerDetailsDTO> findOne(Long id) {
        log.debug("Request to get CustomerDetails : {}", id);
        return customerDetailsRepository.findOneWithEagerRelationships(id).map(customerDetailsMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete CustomerDetails : {}", id);
        customerDetailsRepository.deleteById(id);
    }
}
