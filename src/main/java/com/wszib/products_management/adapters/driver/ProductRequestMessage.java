package com.wszib.products_management.adapters.driver;

import com.wszib.products_management.hexagon.core.ESeason;
import com.wszib.products_management.hexagon.core.ProductFeature;

import java.util.Set;

public record ProductRequestMessage(
        String ean,
        ESeason season,
        String manufacturer,
        String name,
        String productType,
        Set<ProductFeature> features,
        String width,
        String profile,
        String rim,
        String loadIndex,
        String speedIndex,
        String dot,
        Integer quantity,
        Integer price
) {

}
