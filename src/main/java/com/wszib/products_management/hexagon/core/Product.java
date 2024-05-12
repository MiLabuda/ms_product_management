package com.wszib.products_management.hexagon.core;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    @Id
    private Long id;

    @NotNull
    private String ean;

    @Enumerated(EnumType.STRING)
    private ESeason season;

    @NotNull
    @NotEmpty
    private String manufacturer;

    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    private String productType;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ProductFeature> features;

    @NotNull
    private String width;

    @NotNull
    private String profile;

    @NotNull
    private String rim;

    @NotNull
    @NotEmpty
    private String loadIndex;

    @NotNull
    @NotEmpty
    private String speedIndex;

    @NotNull
    @NotEmpty
    private String dot;

    @NotNull
    private Integer quantity;

    @NotNull
    private Integer price;
}
