package com.wszib.products_management.adapters.driver;

import com.wszib.products_management.hexagon.core.Product;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapper {
    public ProductDTO productToProductDTO(Product product){
        return new ProductDTO(
                product.getId(),
                product.getEan(),
                product.getSeason(),
                product.getManufacturer(),
                product.getName(),
                product.getProductType(),
                product.getFeatures(),
                product.getWidth(),
                product.getProfile(),
                product.getRim(),
                product.getLoadIndex(),
                product.getSpeedIndex(),
                product.getDot(),
                product.getQuantity(),
                product.getPrice()
        );
    }

    public Product productDTOToProduct(ProductDTO productDTO){
        return new Product(
                productDTO.id(),
                productDTO.ean(),
                productDTO.season(),
                productDTO.manufacturer(),
                productDTO.name(),
                productDTO.productType(),
                productDTO.features(),
                productDTO.width(),
                productDTO.profile(),
                productDTO.rim(),
                productDTO.loadIndex(),
                productDTO.speedIndex(),
                productDTO.dot(),
                productDTO.quantity(),
                productDTO.price()
        );
    }

    public List<ProductDTO> productsToProductsDTO(List<Product> products) {
        return products.stream()
                .map(this::productToProductDTO)
                .collect(Collectors.toList());
    }
}
