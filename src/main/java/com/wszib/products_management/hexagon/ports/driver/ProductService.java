package com.wszib.products_management.hexagon.ports.driver;

import com.wszib.products_management.hexagon.core.Product;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;


public interface ProductService {

    List<Product> findAll(Pageable pageable);

    Optional<Product> getProductById(Long id);

    Product getProductByIdOrThrow(Long id);

    Optional<Product> getProductByEan(String ean);

    Product getProductByEanOrThrow(String ean);

    Product createProduct(Product product);

    Long deleteProduct(Long id);
}
