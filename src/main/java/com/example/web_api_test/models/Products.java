package com.example.web_api_test.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ProductId;
    private String ProductName;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "products", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Properties> Properties;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "products", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<ProductDetailPropertyDetails> productDetailPropertyDetails;

}
