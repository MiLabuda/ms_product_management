package com.wszib.products_management.hexagon.core;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product_features")
public class ProductFeature {

    @Id
    private Long id;

    private String name;

    private Long featureId;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
