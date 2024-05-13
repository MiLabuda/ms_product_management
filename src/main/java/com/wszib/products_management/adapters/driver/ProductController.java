package com.wszib.products_management.adapters.driver;

import com.wszib.products_management.hexagon.core.Product;
import com.wszib.products_management.hexagon.ports.driver.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final ProductMapper productMapper;

    @GetMapping()
    public ResponseEntity<List<ProductDTO>> getAllProducts(@PageableDefault(size = 5) Pageable pageable) {
        List<ProductDTO> products = productMapper.productsToProductsDTO(productService.findAll(pageable));
        return ResponseEntity.ok(products);
    }


    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(
            @PathVariable Long id) {
        return ResponseEntity.ok(productMapper.productToProductDTO(productService.getProductByIdOrThrow(id)));
    }

    @PostMapping()
    public ResponseEntity<ProductDTO> createProduct(
            @RequestBody ProductRequestMessage productApiRequest) {
        Product product = productMapper.productRequestMessageToProduct(productApiRequest);
        productService.createProduct(product);
        return ResponseEntity.ok(productMapper.productToProductDTO(product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteProduct(
            @PathVariable Long id) {
        productService.getProductByIdOrThrow(id);
        return ResponseEntity.ok(productService.deleteProduct(id));
    }


}
