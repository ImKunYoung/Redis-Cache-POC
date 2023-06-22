package com.poc.redis.application.service;

import com.poc.redis.domain.model.ProductOrder;
import com.poc.redis.infrastructure.repository.ProductOrderRepository;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link ProductOrder}.
 */
@Service
@Transactional
public class ProductOrderServiceImpl implements ProductOrderService {

    private final Logger log = LoggerFactory.getLogger(ProductOrderServiceImpl.class);

    private final ProductOrderRepository productOrderRepository;

    public ProductOrderServiceImpl(ProductOrderRepository productOrderRepository) {
        this.productOrderRepository = productOrderRepository;
    }

    @Override
    public ProductOrder save(ProductOrder productOrder) {
        log.debug("Request to save ProductOrder : {}", productOrder);
        return productOrderRepository.save(productOrder);
    }

    @Override
    public ProductOrder update(ProductOrder productOrder) {
        log.debug("Request to update ProductOrder : {}", productOrder);
        return productOrderRepository.save(productOrder);
    }

    @Override
    public Optional<ProductOrder> partialUpdate(ProductOrder productOrder) {
        log.debug("Request to partially update ProductOrder : {}", productOrder);

        return productOrderRepository
            .findById(productOrder.getId())
            .map(existingProductOrder -> {
                if (productOrder.getQuantity() != null) {
                    existingProductOrder.setQuantity(productOrder.getQuantity());
                }
                if (productOrder.getTotalPrice() != null) {
                    existingProductOrder.setTotalPrice(productOrder.getTotalPrice());
                }

                return existingProductOrder;
            })
            .map(productOrderRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductOrder> findAll() {
        log.debug("Request to get all ProductOrders");
        return productOrderRepository.findAll();
    }

    public Page<ProductOrder> findAllWithEagerRelationships(Pageable pageable) {
        return productOrderRepository.findAllWithEagerRelationships(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ProductOrder> findOne(Long id) {
        log.debug("Request to get ProductOrder : {}", id);
        return productOrderRepository.findOneWithEagerRelationships(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete ProductOrder : {}", id);
        productOrderRepository.deleteById(id);
    }
}
