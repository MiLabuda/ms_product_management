package com.wszib.products_management.hexagon.core;

import com.wszib.products_management.adapters.driven.ProductRepository;
import com.wszib.products_management.hexagon.ports.driver.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable).getContent();
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product getProductByIdOrThrow(Long id) {
        return productRepository
                .findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product with id: " + id + " not found"));
    }

    @Override
    public Optional<Product> getProductByEan(String ean) {
        return productRepository.findByEan(ean);
    }

    @Override
    public Product getProductByEanOrThrow(String ean) {
        return productRepository
                .findByEan(ean)
                .orElseThrow(() -> new ProductNotFoundException("Product with ean: " + ean + " not found"));
    }


    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Long deleteProduct(Long id) {
        productRepository.deleteById(id);
        return id;
    }
}
