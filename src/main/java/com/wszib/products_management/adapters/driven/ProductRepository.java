package com.wszib.products_management.adapters.driven;

import com.wszib.products_management.hexagon.core.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Page<Product> findAll(Pageable pageable);

    Optional<Product> findByEan(String ean);
}
